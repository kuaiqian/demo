package com.duobaoyu.seata.service;

import com.duobaoyu.seata.feign.OrderService;
import com.duobaoyu.seata.feign.StorageService;
import com.duobaoyu.seata.model.Order;
import io.seata.rm.tcc.TwoPhaseResult;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FS001338
 * @date 2020/12/17
 */
@Service
@Slf4j
public class OrderTccActionServiceImpl implements OrderTccActionService {
    @Autowired
    private OrderService orderService;

    @Override
    public Order create(String userId, String commodityCode, Integer count) {
        return orderService.create(userId, commodityCode, count);
    }

    @Override
    public TwoPhaseResult commit(BusinessActionContext businessActionContext) {
        log.info("create================================>commit");
        return new TwoPhaseResult(true, "success");
    }

    @Override
    public TwoPhaseResult rollback(BusinessActionContext businessActionContext) {
        log.info("create================================>rollback");
        return new TwoPhaseResult(true, "success");
    }
}
