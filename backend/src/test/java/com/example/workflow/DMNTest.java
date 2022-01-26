package com.example.workflow;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Deployment("example_dmn.dmn")
public class DMNTest extends AbstractProcessEngineRuleTest {

    @Autowired
    private DecisionService decisionService;

    @Test
    public void shouldExecuteHappyPath() {
        DmnDecisionTableResult decisionResult = decisionService
                .evaluateDecisionTableByKey("DMN_001", Variables.createVariables()
                        .putValue("userType", "Worker")
                        .putValue("userName", "Tomasz"));

        assertEquals(true, decisionResult.getFirstResult().get("result"));
    }
}
