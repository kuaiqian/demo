package com.duobaoyu;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

/**
 * @author FS001338
 * @date 2020/12/23
 */
@SpringBootApplication
@NacosPropertySource(dataId = "test.properties", autoRefreshed = true)
@EnableNacosConfig
public class RegistryCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryCenterApplication.class, args);
    }
}
