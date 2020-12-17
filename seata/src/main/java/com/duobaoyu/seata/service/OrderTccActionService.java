package com.duobaoyu.seata.service;

import com.duobaoyu.seata.model.Order;

import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author FS001338
 * @date 2020/12/17
 */
@LocalTCC
public interface OrderTccActionService extends TccTwoPhaseAction {

    @TwoPhaseBusinessAction(name = "order-tcc", commitMethod = "commit", rollbackMethod = "rollback")
    Order create(@BusinessActionContextParameter(paramName = "userId") String userId,
        @BusinessActionContextParameter(paramName = "commodityCode") String commodityCode,
        @BusinessActionContextParameter(paramName = "count") Integer count);

}
