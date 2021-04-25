package com.duobaoyu.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FS001338
 * @date 2021/4/14
 */
@RestController
@RequestMapping("/test")
public class DemoInterceptorController {

    @GetMapping("/get")
    public String getTest(String test) {
        return test;
    }
}
