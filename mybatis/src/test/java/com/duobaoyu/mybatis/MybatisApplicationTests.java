package com.duobaoyu.mybatis;

import com.duobaoyu.mybatis.mapper.UserMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MybatisApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Resource
    private HikariDataSource hikariDataSource;

    @Test
    void testSelectUser() {
        System.out.println(userMapper.selectAll());
    }

    @Test
    void testGetConnectionConcurent() throws SQLException, IOException {
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    hikariDataSource.getConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Connection connection = hikariDataSource.getConnection();
        Connection connection1 = hikariDataSource.getConnection();
        connection.close();;
        connection1.close();
        Connection connection2 = hikariDataSource.getConnection();
    }

    public static void main(String[] args) throws InterruptedException {
//        SynchronousQueue synchronousQueue = new SynchronousQueue(true);
//        new Thread(() -> {
//            try {
//                Object take = synchronousQueue.take();
//                System.out.println("taked:" + take);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(1L);
//        boolean a = synchronousQueue.offer("a");
//        System.out.println(a);
    }
}
