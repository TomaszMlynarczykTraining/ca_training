package com.example.workflow.delegate;

import com.example.workflow.TicketProcess;
import com.example.workflow.mvc.entity.Pizza;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SavePaymentDelegate implements JavaDelegate {

    @Autowired
    private RuntimeService runtimeService;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //operacje techniczno biznesowe
        //flush do bazy danych

        delegateExecution.setVariable(TicketProcess.PR01_ST1_SAVE_PAYMENT_IS_PAYED, true);

        Pizza pizza = Pizza.builder().name("Pizza").id(1).build();
        Pizza pizza2 = Pizza.builder().name("Pizza2").id(1).build();

        ArrayList<Pizza> pizzas = new ArrayList<>();

        pizzas.add(pizza);
        pizzas.add(pizza2);

        delegateExecution.setVariable("pizza", pizza);

        delegateExecution.setVariable("pizzaList", pizzas);

        delegateExecution.getVariable("pizza")


    }
}
