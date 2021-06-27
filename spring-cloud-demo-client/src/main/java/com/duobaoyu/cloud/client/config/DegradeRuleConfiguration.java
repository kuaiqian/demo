package com.duobaoyu.cloud.client.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.util.TimeUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FS001338
 * @date 2021/4/23
 */
@Component
public class DegradeRuleConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
//        List<DegradeRule> rules = new ArrayList<>();
//        DegradeRule rule = new DegradeRule();
//        rule.setResource("GET:http://demo-a2/test/getHello");
//        // set threshold rt, 10 ms
//        rule.setCount(0.5);
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
//        rule.setTimeWindow(10);
//        rules.add(rule);
//        DegradeRuleManager.loadRules(rules);

        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("GET:http://demo-a2/test/getHello");
        // set threshold rt, 10 ms
        flowRule.setCount(2);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        flowRule.setMaxQueueingTimeMs(10*1000);
        flowRules.add(flowRule);
        FlowRuleManager.loadRules(flowRules);
    }
}
