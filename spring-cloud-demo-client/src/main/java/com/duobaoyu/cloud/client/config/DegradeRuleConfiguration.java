package com.duobaoyu.cloud.client.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

/**
 * @author FS001338
 * @date 2021/4/23
 */
@Component
public class DegradeRuleConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("GET:http://demo-a2/test/getHello");
        // set threshold rt, 10 ms
        rule.setCount(2);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setTimeWindow(10);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }
}
