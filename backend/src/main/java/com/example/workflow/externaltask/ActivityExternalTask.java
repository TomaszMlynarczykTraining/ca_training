package com.example.workflow.externaltask;

import com.example.workflow.mvc.service.UserActionService;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("activityExternalTask.getAction")
public class ActivityExternalTask implements ExternalTaskHandler {

    private final UserActionService userActionService;
    private final RuntimeService runtimeService;

    public ActivityExternalTask(UserActionService userActionService, RuntimeService runtimeService) {
        this.userActionService = userActionService;
        this.runtimeService = runtimeService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String userAction = userActionService.getUserAction();

        runtimeService.setVariable(externalTask.getExecutionId(), "userAction", userAction);
        externalTaskService.complete(externalTask);
    }

}
