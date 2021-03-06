package com.duobaoyu.seata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duobaoyu.seata.feign.StorageService;

import io.seata.rm.tcc.TwoPhaseResult;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author FS001338
 * @date 2020/12/2
 */
@Service
@Slf4j
public class StorageTccActionServiceImpl implements StorageTccActionService {

    @Autowired
    private StorageService storageService;

    @Override
    public void deduct(String commodityCode, int count) {
        storageService.deduct(commodityCode, count);
    }

    @Override
    public TwoPhaseResult commit(BusinessActionContext businessActionContext) {
        log.info("deduct================================>commit");
        return new TwoPhaseResult(true, "success");
    }

    @Override
    public TwoPhaseResult rollback(BusinessActionContext businessActionContext) {
        log.info("deduct================================>rollback");
        return new TwoPhaseResult(true, "success");
    }
}
