package com.duobaoyu.order;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@SpringBootApplication
@MapperScan("com.duobaoyu.mybatis.mapper")
@EnableAutoDataSourceProxy
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
