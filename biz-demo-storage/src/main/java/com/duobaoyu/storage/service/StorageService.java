package com.duobaoyu.storage.service;

import com.duobaoyu.mybatis.entity.StorageTbl;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/11/26
 */
public interface StorageService {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);

    /**
     * insert 保存
     * 
     * @param commodityCode
     * @param count
     * @return
     */
    boolean save(String commodityCode, int count);

    /**
     * 条件查询
     * 
     * @param id
     * @return
     */
    StorageTbl selectByCommodityCode(Integer id);

    /**
     * 子查询，join
     * 
     * @return
     */
    List<StorageTbl> subQuery();
}
