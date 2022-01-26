package com.example.workflow;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Assert;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.decisionService;

@Deployment(resources = {"decisionTable.dmn"})
public class DecisionTableTest extends AbstractProcessEngineRuleTest {

    @Test
    public void aa() {

        DmnDecisionTableResult dmnDecisionRuleResults = decisionService().evaluateDecisionTableByKey("example",
                Variables.createVariables()
                        .putValue("PizzaType", "NORMAL")
                        .putValue("Islogged", "1")
                        .putValue("ToppingName", "Pepperoni"));
        Assert.assertEquals("20", dmnDecisionRuleResults.getFirstResult());
    }
}
