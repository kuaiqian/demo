package com.example.demo;

import com.example.demo.feign.FeignClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    FeignClientService feignClientService;

    @Test
    void contextLoads() {
        String lihao = feignClientService.getHello("lihao");
        System.out.println("========>"+lihao);
    }

}
