package com.example.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubProcessTest {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void happyPath() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("subprocess1");
        assertThat(processInstance).isStarted().isActive();
        String taskId = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult()
                .getId();
        taskService.complete(taskId);
        assertThat(processInstance).isEnded();
    }
}
