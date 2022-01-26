package com.example.workflow;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ExternalTaskSubscription("pizza.externalService")
public class PizzaExternalTaskHandler implements ExternalTaskHandler {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.boredapi.com/api/activity";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        runtimeService.setVariable(externalTask.getExecutionId(), "response", response.getBody());
        externalTaskService.complete(externalTask);

    }
}
