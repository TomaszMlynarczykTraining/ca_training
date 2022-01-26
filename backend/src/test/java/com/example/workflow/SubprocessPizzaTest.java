package com.example.workflow;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;

@Deployment(resources = {"diagram_2.bpmn"})
public class SubprocessPizzaTest extends AbstractProcessEngineRuleTest {

/*    @Autowired
    public RuntimeService runtimeService;

    @Autowired
    public TaskService taskService;*/

    @Test
    public void shouldExecuteHappyPath() {
        // given
        String processDefinitionKey = "SP01_PIZZA_SUBPROCESS";

        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(processDefinitionKey);
/*
        String firstTaskId = taskService()
                .createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult()
                .getId();

        taskService().complete(firstTaskId);*/

        assertThat(processInstance).isStarted()
                .task()
                .hasDefinitionKey("SP01_ST1_PIZZA");
    }
}
