package com.example.workflow.mvc.service;

import com.example.workflow.mvc.entity.UserPizzaTopping;
import com.example.workflow.mvc.repository.UserPizzaToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPizzaTopingService {


    @Autowired
    private UserPizzaToppingRepository userPizzaToppingRepository;


    public void save(UserPizzaTopping userPizzaTopping) {
        userPizzaToppingRepository.save(userPizzaTopping);
    }
}
