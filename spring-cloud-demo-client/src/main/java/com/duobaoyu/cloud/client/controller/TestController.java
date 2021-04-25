package com.duobaoyu.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duobaoyu.cloud.client.feign.DemoFeign;

/**
 * @author FS001338
 * @date 2021/4/21
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    public DemoFeign demoFeign;

    @GetMapping(value = "/sayHi")
    public String sayHi(String hi) {
        String result = demoFeign.sayHi(hi);
        return result;
    }

    @GetMapping(value = "/getHello")
    public String getHello(String hi, Integer sleepTime) {
        String result = demoFeign.getHello(hi, sleepTime);
        return result;
    }
}
