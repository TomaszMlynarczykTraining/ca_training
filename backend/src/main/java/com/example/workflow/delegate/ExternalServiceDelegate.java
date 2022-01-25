package com.example.workflow.delegate;

import com.example.workflow.mvc.service.RestService;
import lombok.AllArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

@Service
@ExternalTaskSubscription("pizzaProcess.getExternalService")
@AllArgsConstructor
public class ExternalServiceDelegate implements ExternalTaskHandler {

    private RestService restService;
    private RuntimeService runtimeService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String response = restService.getBoredApi();
        runtimeService.setVariable(externalTask.getExecutionId(), "response", response);
        externalTaskService.complete(externalTask);
    }
}
