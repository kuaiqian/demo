package com.duobaoyu.mybatis;

import com.duobaoyu.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectUser() {
        System.out.println(userMapper.selectAll());
    }

}
