package com.duobaoyu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@SpringBootApplication(scanBasePackages = "com.duobaoyu")
@EnableAsync
public class DemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
