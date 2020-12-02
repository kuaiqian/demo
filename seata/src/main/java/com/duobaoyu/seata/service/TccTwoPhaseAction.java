package com.duobaoyu.seata.service;

import io.seata.rm.tcc.TwoPhaseResult;
import io.seata.rm.tcc.api.BusinessActionContext;

/**
 * @author FS001338
 * @date 2020/12/2
 */
public interface TccTwoPhaseAction {

    TwoPhaseResult commit(BusinessActionContext businessActionContext);

    TwoPhaseResult rollback(BusinessActionContext businessActionContext);
}
