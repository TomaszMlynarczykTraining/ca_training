package com.example.workflow;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@Deployment(resources = {"PR_01_ORDER_PIZZA.bpmn", "EXTERNAL_PROCCESS.bpmn"})
public class OrderPizzaTest extends AbstractProcessEngineRuleTest {

    @Test
    public void shouldExecuteHappyPath() {
        // given
        String processDefinitionKey = "ORDER_PIZZA_PROCESS_1";

        // when
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(processDefinitionKey);

        String firstTaskId = taskService()
                .createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult()
                .getId();

        assertThat(processInstance).hasPassed("PR_01_ST_01_GetUserData");

        runtimeService().signal("Event_133irc8");

//        Job job = jobQuery().processDefinitionKey(processDefinitionKey).singleResult();
//        execute(job);


        System.out.println("asdfasdfhbasjhdfvajasdasdasdawsdshdvf " + firstTaskId);

        // then

        assertThat(processInstance).isStarted();
//                .task()
//                .hasDefinitionKey("ORDER_PIZZA_PROCESS_1")
//                .isNotAssigned();
    }

//
//    @Autowired
//    public RuntimeService runtimeService;
//
//    @Autowired
//    public TaskService taskService;
//
//    @Test
//    public void shouldExecuteHappyPath() {
//        // given
//        String processDefinitionKey = "ORDER_PIZZA_PROCESS_1";
//
//        // when
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("salary", 5000);
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
//
//        String firstTaskId = taskService
//                .createTaskQuery()
//                .processInstanceId(processInstance.getId())
//                .singleResult()
//                .getId();
//        Map<String, Object> firstTaskVariables = new HashMap<>();
//        firstTaskVariables.put("hrDecision", true);
//        taskService.complete(firstTaskId, firstTaskVariables);
//
//        String secondTaskId = taskService
//                .createTaskQuery()
//                .processInstanceId(processInstance.getId())
//                .singleResult()
//                .getId();
//        taskService.complete(secondTaskId);
//
//        // then
//        assertThat(processInstance)
//                .isEnded()
//                .hasPassed("Event_Hired");
//    }
}
