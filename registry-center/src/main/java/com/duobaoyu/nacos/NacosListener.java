package com.duobaoyu.nacos;

import javax.annotation.PostConstruct;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.exception.NacosException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author FS001338
 * @date 2020/12/23
 */
@Configuration
@Slf4j
@NacosPropertySource(dataId = "test.properties",autoRefreshed = true)
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
