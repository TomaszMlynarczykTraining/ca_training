package com.example.workflow.delegate;

import com.example.workflow.TicketProcess;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentDelegate implements JavaDelegate {

    @Autowired
    private RuntimeService runtimeService;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //operacje techniczno biznesowe
        //flush do bazy danych

        delegateExecution.setVariable(TicketProcess.PR01_ST1_SAVE_PAYMENT_IS_PAYED, true);

      
    }
}
