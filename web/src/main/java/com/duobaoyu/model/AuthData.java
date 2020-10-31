package com.duobaoyu.model;

import lombok.Data;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/10/30
 */
@Data
public class AuthData {

    private Integer empId;

    private List<Integer> orgIds;
}
