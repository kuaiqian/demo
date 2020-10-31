package com.duobaoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@SpringBootApplication(scanBasePackages = "com.duobaoyu")
public class SentinelDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
    }
}
