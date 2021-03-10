package com.duobaoyu.spring.model;

import lombok.Data;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/12/22
 */
@Data
public class User {

    private String name;

    private Integer age;

    private List<String> address;

    public void run() {
        System.out.println("user run");
    }

    public String run(String input) {
        return "return:"+input;
    }
}
