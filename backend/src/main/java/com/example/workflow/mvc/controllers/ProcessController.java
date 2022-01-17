package com.example.workflow.mvc.controllers;


import com.example.workflow.mvc.entity.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/process")
public class ProcessController {

    @PostMapping("/start")
    public void startProcessForUser(@RequestBody User user) {


    }
}
