package com.duobaoyu.web.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FS001338
 * @date 2020/11/18
 */
@RestController
@RequestMapping("/cross")
public class TestCrossOrignController {

    @GetMapping("/get")
    public String getResult() {
        return "success";
    }

    @GetMapping("/getByParam")
    @ResponseBody
    @CrossOrigin
    public String getResult(String param, @RequestHeader("log")String log, HttpServletRequest httpServletRequest) throws JSONException {
        System.out.println(log);
        JSONObject map = new JSONObject();
        map.put("name",11);
        return map.toString();
    }


}
