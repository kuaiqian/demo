package com.duobaoyu.web.annotation;

import java.lang.annotation.*;

/**
 * @author FS001338
 * @date 2020/10/30
 */
@Target({ElementType.TYPE, ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
