package com.example.workflow.delegate;


import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockDelegate implements JavaDelegate {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String processBusinessKey = delegateExecution.getProcessBusinessKey();


        List<Task> list = taskService.createTaskQuery().processInstanceBusinessKey(processBusinessKey)
                .or().processInstanceId(delegateExecution.getProcessInstanceId()).list();

    }
}
