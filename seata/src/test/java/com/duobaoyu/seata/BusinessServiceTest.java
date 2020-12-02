package com.duobaoyu.seata;

import com.duobaoyu.seata.service.BusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author FS001338
 * @date 2020/11/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessServiceTest {
    @Autowired
    private BusinessService businessService;

    @Test
    public void purchase() {
        businessService.purchase("1234", "1", 3);
    }


    @Test
    public void purchaseTcc() {
        businessService.purchaseTcc("1234", "1", 3);
    }
}


