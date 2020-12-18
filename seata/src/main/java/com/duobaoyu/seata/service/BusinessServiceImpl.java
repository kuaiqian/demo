package com.duobaoyu.seata.service;

import com.duobaoyu.seata.feign.AccountService;
import com.duobaoyu.seata.feign.OrderService;
import com.duobaoyu.seata.feign.StorageService;
import com.duobaoyu.seata.model.Order;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private OrderService orderService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageTccActionService storageTccActionService;

    @Autowired
    private OrderTccActionService orderTccActionService;

    @Override
    @GlobalTransactional(name = "purchase")
    public void purchase(String userId, String commodityCode, Integer orderCount, boolean rollback) {
        // 1.扣减库存
        storageService.deduct(commodityCode, orderCount);
        // 2.下单
        Order order = orderService.create(userId, commodityCode, orderCount);
        // 3.扣钱
        accountService.debit(userId, 2);
        if (rollback) {
            throw new RuntimeException();
        }
    }

    @Override
    @GlobalTransactional(name = "purchaseTcc")
    public void purchaseTcc(String userId, String commodityCode, Integer count, boolean rollback) {
        storageTccActionService.deduct(commodityCode, count);
        orderTccActionService.create(userId, commodityCode, count);
        if (rollback) {
            throw new RuntimeException("一阶段失败");
        }
    }
}
