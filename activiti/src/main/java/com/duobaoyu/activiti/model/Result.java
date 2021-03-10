package com.duobaoyu.activiti.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author FS001338
 * @date 2020/12/26
 */
@Data
@Builder
public class Result<T> implements Serializable {

    private String code;

    private String message;

    private T data;
}
