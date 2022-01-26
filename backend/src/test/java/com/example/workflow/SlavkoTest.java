package com.example.workflow;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@Deployment(resources = {"pizza_order.bpmn"})
public class SlavkoTest extends AbstractProcessEngineRuleTest {

    @Test
    public void isProcessOK() {
        // given
        String processDefinitionKey = "PR01_PIZZA_ORDER";

        // when
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(processDefinitionKey);

        assertThat(processInstance).isStarted().task().hasDefinitionKey("PR02_UT01").isNotAssigned();
        System.out.println("!!!TEST!!! After first assert");
        String taskId = taskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getId();

        taskService().complete(taskId);

        assertThat(processInstance).isEnded();

        System.out.println("!!!TEST!!! After second assert");
    }
}
