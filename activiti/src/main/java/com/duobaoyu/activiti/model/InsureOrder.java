package com.duobaoyu.activiti.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author FS001338
 * @date 2020/12/25
 */
@Data
public class InsureOrder implements Serializable {

    private String productCode;

    private String productName;

    private Integer acId;

    private Map<String,Object> extendVars;
}
