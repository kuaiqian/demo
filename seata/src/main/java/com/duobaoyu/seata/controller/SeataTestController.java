package com.duobaoyu.seata.controller;

import com.duobaoyu.seata.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FS001338
 * @date 2020/12/2
 */
@RestController
public class SeataTestController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/testTcc")
    public void testTcc(){
        businessService.purchaseTcc("1234","1",2);
    }
}
