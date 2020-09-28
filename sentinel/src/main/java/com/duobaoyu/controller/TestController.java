package com.duobaoyu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@RestController
@Slf4j
@CrossOrigin
public class TestController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        return "hello," + name;
    }
}
