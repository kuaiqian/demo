package com.duobaoyu.storage.service;

import com.duobaoyu.mybatis.mapper.StorageTblMapper;
import org.springframework.stereotype.Service;

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
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
    }
}
