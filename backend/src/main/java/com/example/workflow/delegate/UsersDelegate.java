package com.example.workflow.delegate;

import com.example.workflow.mvc.entity.User;
import com.example.workflow.mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersDelegate implements JavaDelegate {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<User> usersAll = userRepository.findAll();
        execution.setVariable("users", usersAll);
    }
}
