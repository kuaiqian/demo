package com.duobaoyu.cloud.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FS001338
 * @date 2021/4/21
 */
@FeignClient(value = "demo-a2")
public interface DemoFeign {

    @PostMapping("/test/sayHi")
    String sayHi(@RequestParam("hi") String hi);

    @GetMapping("/test/getHello")
    String getHello(@RequestParam("hi") String hi, @RequestParam("sleepTime") Integer sleepTime);
}
