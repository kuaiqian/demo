package com.duobaoyu.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author FS001338
 * @date 2020/11/27
 */
@SpringBootApplication
@EnableFeignClients
//@EnableAutoDataSourceProxy
public class SeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataApplication.class, args);
    }
}
