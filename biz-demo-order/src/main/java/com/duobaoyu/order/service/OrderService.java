package com.duobaoyu.order.service;

import com.duobaoyu.mybatis.entity.OrderTbl;

/**
 * @author FS001338
 * @date 2020/11/26
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    OrderTbl create(String userId, String commodityCode, int orderCount);
}
