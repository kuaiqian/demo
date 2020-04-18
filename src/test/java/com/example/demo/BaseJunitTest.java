package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseJunitTest {

    @Before
    public void testBefore(){
        System.out.println("==================>开始");
    }

    @After
    public void testAfter(){
        System.out.println("==================>结束");
    }
}
