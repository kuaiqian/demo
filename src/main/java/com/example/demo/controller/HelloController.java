package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengchen
 * @version 1.0
 * @date 2020/4/18 15:46
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String getHello(String name){
        return  "hello!"+name;
    }
}
