package com.duobaoyu.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author FS001338
 * @date 2020/12/23
 */
@Configuration
@Slf4j
public class NacosListener {

    @NacosInjected
    private ConfigService configService;

    @PostConstruct
    public void init() throws NacosException {
        String config = configService.getConfig("test.properties", "DEFAULT_GROUP", 1000);
        System.out.println("init config:"+config);
    }

    @NacosConfigListener(dataId = "test.properties")
    public void onMessage(String config) {
        System.out.println("config:" + config);
    }
}
