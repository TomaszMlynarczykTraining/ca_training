package com.example.workflow.delegate;

import com.example.workflow.mvc.entity.Pizza;
import com.example.workflow.mvc.service.PizzaService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NormalPizzaMenuDelegate implements JavaDelegate {

    private final PizzaService pizzaService;

    public NormalPizzaMenuDelegate(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Pizza> normalPizzas = pizzaService.getNormalPizzas();
        execution.setVariable("normalPizzaVariable", normalPizzas);
    }


}
