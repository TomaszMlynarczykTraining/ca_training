package com.example.workflow;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.workflow.TicketProcess.PR01_ET1_GET_TICKET_INFO_TICKET_TYPE;

@Component
@ExternalTaskSubscription("ticketSerive.getTicketInformation")
public class TicketInformationHandler implements ExternalTaskHandler {

    @Autowired
    private RuntimeService runtimeService;


    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        //Korzystanie z Runtime Service

        runtimeService.setVariable(externalTask.getExecutionId(), PR01_ET1_GET_TICKET_INFO_TICKET_TYPE, "NORMAL");


        //VariableMap
/*        VariableMap variables = Variables.createVariables();
        variables.put(PR01_ET1_GET_TICKET_INFO_TICKET_TYPE, "NORMAL");
        externalTaskService.setVariables(externalTask, variables);*/
        externalTaskService.complete(externalTask);
    }
}
