package com.example.workflow.delegate;

import com.example.workflow.mvc.entity.User;
import com.example.workflow.mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GetUserDelegate implements JavaDelegate {

    private UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<User> allUser = userRepository.findAll();

        execution.setVariable("users", allUser);

    }
}
