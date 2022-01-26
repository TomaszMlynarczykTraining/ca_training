package com.example.workflow.remote;

import com.example.workflow.TicketProcess;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ExternalTaskSubscription("ticketService.randomUserTask")
public class RandomUserTaskExternalHandler implements ExternalTaskHandler {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        ResponseEntity<UserTask> userTask = restTemplate.getForEntity("https://www.boredapi.com/api/activity/", UserTask.class);
        if (userTask.getStatusCode() == HttpStatus.OK) {
            System.out.println("User activity loaded" + userTask.getBody().getActivity());
            runtimeService.setVariable(externalTask.getExecutionId(), TicketProcess.PR01_USER_TASK, userTask.getBody().getActivity());
            externalTaskService.complete(externalTask);
        } else {
            externalTaskService.handleBpmnError(externalTask, "Wrong response status: " + userTask.getStatusCode());
        }
    }
}
