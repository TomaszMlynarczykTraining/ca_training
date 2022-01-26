package com.example.workflow.mvc.service;

import com.example.workflow.mvc.entity.Pizza;
import com.example.workflow.mvc.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {


    @Autowired
    private PizzaRepository pizzaRepository;


    public List<Pizza> getPizzas() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> getNormalPizzas() {
        return pizzaRepository.findByName("NORMAL");
    }
}
