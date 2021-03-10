package com.duobaoyu.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * @author FS001338
 * @date 2020/12/25
 */
@Service
public class HebaoService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("hebao service start");
        execution.setVariable("result",true);
        System.out.println("hebao service end");

    }
}
