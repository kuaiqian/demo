package com.duobaoyu.cloud.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author FS001338
 * @date 2021/4/21
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value(("${common.demoName}"))
    private String commonDemoName;

    @Value(("${ext.demoName}"))
    private String extDemoName;

    @Value(("${user.demoName}"))
    private String demoName;

    @PostMapping("/sayHi")
    public String sayHi(String hi) {
        return "demo2:" + hi;
    }

    @GetMapping("/getHello")
    public String getHello(String hi, Integer sleepTime) {
        System.out.printf("commonDemoName:%s,extDemoName:%s,demoName:%s,getHello:%s", commonDemoName, extDemoName, demoName, hi);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========>" + hi);
        return "demo2:" + hi;
    }
}
