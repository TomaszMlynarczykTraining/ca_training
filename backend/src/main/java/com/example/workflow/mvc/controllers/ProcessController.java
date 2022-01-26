package com.example.workflow.mvc.controllers;


import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/process")
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/start")
    public void startProcessForBusinessKey(String businessKey) {
        runtimeService.startProcessInstanceByKey("PR01-PIZZA-PROCESS", businessKey);
    }

    @PostMapping("/corellate")
    public void corellateMessage(String messageName, String businessKey) {
        runtimeService.correlateMessage(messageName, businessKey);
    }

}
