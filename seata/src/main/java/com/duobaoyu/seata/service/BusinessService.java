package com.duobaoyu.seata.service;

/**
 * 业务服务
 *
 * @author FS001338
 * @date 2020/11/26
 */
public interface BusinessService {

    void purchase(String userId, String commodityCode, Integer count, boolean rollback);

    void purchaseTcc(String userId, String commodityCode, Integer count, boolean rollback);
}
