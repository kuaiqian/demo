package com.duobaoyu.storage.service;

import com.duobaoyu.mybatis.entity.StorageTbl;
import com.duobaoyu.mybatis.mapper.StorageTblMapper;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public boolean save(String commodityCode, int count) {
        StorageTbl storageTbl = new StorageTbl();
        storageTbl.setCommodityCode(commodityCode);
        storageTbl.setCount(100);
        int num = storageTblMapper.insert(storageTbl);
        return num > 0;
    }

    @Override
    public StorageTbl selectByCommodityCode(Integer id) {
        StorageTbl storageTbl = storageTblMapper.selectByPrimaryKey(id);
        return storageTbl;
    }

    @Override
    public List<StorageTbl> subQuery() {
        return storageTblMapper.selectBySubQuery();
    }
}
