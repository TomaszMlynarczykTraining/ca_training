package com.example.workflow.delegate;

import com.example.workflow.mvc.entity.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class MailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        User user = (User) execution.getVariable("user");
//        Thread.sleep(1500);
        System.out.println("Send mail to user: " + user + ", thread: " + Thread.currentThread().getName());
    }
}
