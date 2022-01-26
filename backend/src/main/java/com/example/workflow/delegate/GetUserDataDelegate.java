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
public class GetUserDataDelegate implements JavaDelegate {

    private UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<User> allUser = userRepository.findAll();
        execution.setVariable("allUser", allUser);
        execution.setVariable("Islogged", allUser.get(0).getIsLogged());
        execution.setVariable("PizzaType", "NORMAL");
        execution.setVariable("ToppingName", "Pepperoni");
    }
}
