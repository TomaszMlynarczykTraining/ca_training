package com.example.workflow.mvc.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.migration.MigrationPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MigrationService {

    @Autowired
    private RuntimeService runtimeService;


    public void migrate(String sourceDefId, String targetId) {

        MigrationPlan migrationPlan = runtimeService
                .createMigrationPlan(sourceDefId, targetId)
                .mapEqualActivities()
                //.mapActivities()
                .build();


        runtimeService
                .newMigration(migrationPlan)
                .processInstanceQuery(runtimeService.createProcessInstanceQuery().processDefinitionId(sourceDefId))
                .execute();
    }
}
