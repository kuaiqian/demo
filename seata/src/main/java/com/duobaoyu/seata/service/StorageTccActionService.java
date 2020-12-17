package com.duobaoyu.seata.service;

import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author FS001338
 * @date 2020/12/2
 */
@LocalTCC
public interface StorageTccActionService extends TccTwoPhaseAction {

    @TwoPhaseBusinessAction(name = "storage-tcc", commitMethod = "commit", rollbackMethod = "rollback")
    void deduct(@BusinessActionContextParameter(paramName = "commodityCode") String commodityCode, int count);
}
