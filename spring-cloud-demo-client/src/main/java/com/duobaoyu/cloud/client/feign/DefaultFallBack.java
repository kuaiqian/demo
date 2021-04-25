package com.duobaoyu.cloud.client.feign;

import org.springframework.stereotype.Component;

/**
 * @author FS001338
 * @date 2021/4/23
 */
@Component
public class DefaultFallBack implements DemoFeign {
    @Override
    public String sayHi(String hi) {
        return "fallback:sayHi" + hi;
    }

    @Override
    public String getHello(String hi,Integer sleepTime) {
        return "fallback:getHello" + hi;
    }
}
