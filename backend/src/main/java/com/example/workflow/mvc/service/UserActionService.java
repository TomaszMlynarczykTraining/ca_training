package com.example.workflow.mvc.service;

import com.example.workflow.mvc.model.ActivityModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserActionService {

    private final String URL = "https://www.boredapi.com/api/activity/";
    private final RestTemplate restTemplate;

    public UserActionService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getUserAction() {
        return this.restTemplate.getForObject(URL, ActivityModel.class).getActivity();
    }

}
