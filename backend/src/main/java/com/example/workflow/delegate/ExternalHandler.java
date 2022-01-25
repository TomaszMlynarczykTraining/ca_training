package com.example.workflow.delegate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@ExternalTaskSubscription("externalTest")
public class ExternalHandler implements ExternalTaskHandler {

    @Autowired
    private RuntimeService runtimeService;

    private String activityVariable = "activity";

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.boredapi.com/api/activity/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode actNode = root.path("activity");
            String value = actNode.textValue();
            runtimeService.setVariable(externalTask.getExecutionId(), activityVariable, value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        externalTaskService.complete(externalTask);
    }


}
