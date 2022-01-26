package com.example.workflow;


import com.example.workflow.delegate.MockDelegate;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@Deployment(resources = {"PR_01_ORDER_PIZZA.bpmn"})
public class ExTest extends AbstractProcessEngineRuleTest {

    @MockBean
    public MockDelegate mockDelegate;

    @Test
    public void shouldExecuteHappyPath() {

        //DelegateExpressions.registerJavaDelegateMock(BookTradeHspad.class);
        Mocks.register("mockDelegate", new MockDelegate());

        // given
        String processDefinitionKey = "Process_1";

        VariableMap startVars = Variables.createVariables();
        startVars.put("pizzaAmount", null);


        // when
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(processDefinitionKey, startVars);

        Task task = taskQuery().processDefinitionKey(processDefinitionKey).singleResult();

        VariableMap variables = Variables.createVariables();
        variables.put("crustChoice", "NEAPOLITAN");
        complete(task, variables);

        Task task2 = taskQuery().processDefinitionKey(processDefinitionKey).singleResult();
        complete(task2);
        assertThat(processInstance).hasPassed("Task_1usyhxd");

        Job timer = jobQuery().processDefinitionKey(processDefinitionKey).singleResult();
        execute(timer);

        Task task3 = taskQuery().processDefinitionKey(processDefinitionKey).singleResult();

        variables.put("pizzaAmount", 0);

        complete(task3, variables);


        assertThat(processInstance).isEnded();
    }
}
