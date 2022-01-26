package com.example.workflow.mvc.controllers;


import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.workflow.TicketProcess.PR01_TICKET_PROCESS;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/process")
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/start")
    public void startProcessForBusinessKey(String businessKey) {
        runtimeService.startProcessInstanceByKey(PR01_TICKET_PROCESS, businessKey);
    }

    @PostMapping("/corellate")
    public void corellateMessage(String messageName, String bizKey) {
        runtimeService.correlateMessage(messageName, bizKey);
    }

}
