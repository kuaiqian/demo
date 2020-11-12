package com.duobaoyu.web.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

/**
 * @author FS001338
 * @date 2020/10/30
 */
@Data
public class TestParam extends BaseParam{

    private String name;

    @Email
    private String email;

    @Max(message = "asasd",value = 3)
    private Integer age;
}
