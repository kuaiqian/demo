package com.duobaoyu.activiti;

import com.alibaba.fastjson.JSON;
import com.duobaoyu.activiti.model.InsureOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.util.json.JSONML;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.json.JSONStringer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FS001338
 * @date 2020/12/24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivitiTest {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @Test
    public void testProcessQuery() {
        long count = repositoryService.createProcessDefinitionQuery().count();
        System.out.println("process count:" + count);
        long tasksNum = taskService.createTaskQuery().count();
        System.out.println("tasks count:" + tasksNum);
        long runTimes = runtimeService.createExecutionQuery().count();
        System.out.println("runtime process:" + runTimes);
    }

    @Test
    public void testDeploy() {
        Deployment insuracneRequest = repositoryService.createDeployment().name("insuracneRequest")
            .addClasspathResource("processes/insurance_request.bpmn20.xml").deploy();
        System.out.println(JSON.toJSONString(insuracneRequest));
    }

    @Test
    @Transactional
    public void testProcess() {
        InsureOrder insureOrder = new InsureOrder();
        insureOrder.setAcId(1);
        insureOrder.setProductCode("B001");
        Map<String, Object> vars = new HashMap<>();
        vars.put("amount", new BigDecimal("1"));
        vars.put("order", insureOrder);
        ProcessInstance insuranceRequest = runtimeService.startProcessInstanceByKey("insuranceRequest", vars);
        System.out.println("process instance:" + insuranceRequest.getId());
        List<HistoricVariableInstance> list = historyService.createHistoricVariableInstanceQuery().variableName("result")
            .processInstanceId(insuranceRequest.getProcessInstanceId()).list();
        System.out.println("result variables:" +  list.get(0).getValue());
    }

    @Test
    public void testTask() {
        Map<String, Object> vars = Maps.newHashMap();
        vars.put("resendRequest", true);
        taskService.complete("15004", vars);
    }
}
