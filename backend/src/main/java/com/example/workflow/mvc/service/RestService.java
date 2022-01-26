package com.example.workflow.mvc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    public String getBoredApi() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://www.boredapi.com/api/activity/";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response.getBody();
    }
}
