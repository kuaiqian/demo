package com.duobaoyu.web.model;

import com.duobaoyu.web.annotation.Auth;
import lombok.Data;

/**
 * @author FS001338
 * @date 2020/10/31
 */
@Auth
@Data
public class BaseParam {

    private String id;
}
