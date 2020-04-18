package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chengchen
 * @version 1.0
 * @date 2020/4/18 14:19
 */
@FeignClient(name="demo",url="127.0.0.1:9000")
public interface FeignClientService {

    @GetMapping(value = "/hello")
    String getHello(@RequestParam String name);
}
