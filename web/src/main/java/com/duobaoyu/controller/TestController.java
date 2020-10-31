package com.duobaoyu.controller;

import com.duobaoyu.annotation.Auth;
import com.duobaoyu.model.AuthData;
import com.duobaoyu.model.TestParam;
import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@RestController
@Slf4j
@CrossOrigin
@ControllerAdvice
public class TestController {

    @PostMapping("/hello")
    @ResponseBody
    public String hello(@RequestBody @Valid TestParam name, @Auth AuthData authData) {
        return "hello," + name + ",auth:" + authData;
    }

    @PostMapping("/hello1")
    @ResponseBody
    @Async
    public CompletableFuture<String> hello1(@RequestBody TestParam name, @Auth AuthData authData) throws ExecutionException, InterruptedException {
        System.out.println("hello1");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello," + name + ",auth:" + authData;
        });
        return stringCompletableFuture;
    }

    @PostMapping("/hello2")
    @ResponseBody
    public String hello2(@RequestBody TestParam name, @Auth AuthData authData) throws ExecutionException, InterruptedException {
        System.out.println("hello2");
        return "hello," + name + ",auth:" + authData;
    }


}
