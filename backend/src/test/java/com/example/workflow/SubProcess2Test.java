package com.example.workflow;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;

@Deployment(resources = {"process.bpmn"})
public class SubProcess2Test extends AbstractProcessEngineRuleTest {
    @Test
    public void shouldExecuteHappyPath() {
        // given
        String processDefinitionKey = "my-project-process";

        // when
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(processDefinitionKey);

        // then

        assertThat(processInstance).isStarted()
                .task()
                .hasDefinitionKey("say-hello")
//                .hasCandidateUser("demo")
                .isNotAssigned();
    }
}
