package com.example.workflow.delegate;

import com.example.workflow.mvc.entity.Pizza;
import com.example.workflow.mvc.repository.PizzaRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class NeapolitanPizzaMenuDelegate implements JavaDelegate {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Pizza> pizzas = pizzaRepository.findAll().stream()
                .filter(p -> p.getType().equals("NEAPOLITAN"))
                .collect(Collectors.toList());

        System.out.println("Neapolitan pizzas found: " + pizzas.size());
        delegateExecution.setVariable("pizzaList", pizzas);
    }
}
