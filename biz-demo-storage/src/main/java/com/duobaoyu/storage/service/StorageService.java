package com.duobaoyu.storage.service;

/**
 * @author FS001338
 * @date 2020/11/26
 */
public interface StorageService {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
