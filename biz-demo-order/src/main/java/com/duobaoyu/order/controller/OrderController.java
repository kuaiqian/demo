package com.duobaoyu.order.controller;

import com.duobaoyu.mybatis.entity.OrderTbl;
import com.duobaoyu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    @ResponseBody
    public OrderTbl create(String userId, String commodityCode, Integer count) {
        return orderService.create(userId, commodityCode, count);
    }
}
