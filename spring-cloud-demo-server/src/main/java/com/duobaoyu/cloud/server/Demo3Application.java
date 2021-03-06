package com.duobaoyu.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author FS001338
 * @date 2021/4/21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Demo3Application {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","a3");
        SpringApplication.run(Demo3Application.class, args);

    }
}
