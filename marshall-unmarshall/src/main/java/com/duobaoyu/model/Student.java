package com.duobaoyu.model;

import lombok.Data;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/12/21
 */
@Data
public class Student {

    private String name;

    private Integer age;

    private List<Address> addressList;
}
