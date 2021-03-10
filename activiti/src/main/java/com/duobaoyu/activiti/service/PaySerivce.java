package com.duobaoyu.activiti.service;

import java.math.BigDecimal;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import com.duobaoyu.activiti.model.Result;
import com.google.common.collect.Maps;

/**
 * @author FS001338
 * @date 2020/12/25
 */
@Service("PaySerivce")
public class PaySerivce {

    public Result<Map<String, Object>> confirmPay(DelegateExecution execution) {
        Object amount = execution.getVariable("amount");
        System.out.println("confirm pay:" + amount);
        Map<String, Object> map = Maps.newHashMap();
        map.put("isPay", true);
        map.put("payNo", "123455");
        Result<Map<String, Object>> result = Result.<Map<String, Object>>builder().code("200").data(map).build();
        return result;
    }

    public Result<Map<String, Object>> cancelPay(BigDecimal amount) {
        System.out.println("cancel pay:" + amount);
        Map<String, Object> map = Maps.newHashMap();
        Result<Map<String, Object>> result =
            Result.<Map<String, Object>>builder().code("500").message("金额不足").data(map).build();
        return result;
    }
}
