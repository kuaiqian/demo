package com.duobaoyu.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@RestController
@Slf4j
@CrossOrigin
public class TestController {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable(name = "name") String name) {
        return "hello," + name;
    }

    @GetMapping("/goodBye/{name}")
    @ResponseBody
    public String goodBye(@PathVariable(name = "name") String name) {
        return "goodBye," + name;
    }
}
