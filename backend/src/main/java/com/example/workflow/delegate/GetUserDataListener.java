package com.example.workflow.delegate;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class GetUserDataListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("I am before Service Task!");
    }
}
