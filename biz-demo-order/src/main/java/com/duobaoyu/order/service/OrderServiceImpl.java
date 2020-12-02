package com.duobaoyu.order.service;

import com.duobaoyu.mybatis.entity.OrderTbl;
import com.duobaoyu.mybatis.mapper.OrderTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderTblMapper orderTblMapper;

    @Override
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(10);
        orderTblMapper.insert(orderTbl);
        return orderTbl;
    }
}
