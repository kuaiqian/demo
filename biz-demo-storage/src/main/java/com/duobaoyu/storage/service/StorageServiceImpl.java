package com.duobaoyu.storage.service;

import com.duobaoyu.mybatis.mapper.StorageTblMapper;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageTblMapper storageTblMapper;

    @Override
    @GlobalLock
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
    }
}
