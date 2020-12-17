package com.duobaoyu.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@SpringBootApplication
@MapperScan("com.duobaoyu.mybatis.mapper")
//@EnableAutoDataSourceProxy
@EnableSwagger2
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
