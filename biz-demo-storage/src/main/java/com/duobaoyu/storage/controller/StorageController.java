package com.duobaoyu.storage.controller;

import com.duobaoyu.mybatis.entity.StorageTbl;
import com.duobaoyu.storage.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/11/26
 */

@RestController
@Api(tags = "仓库API")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/deduct")
    @ResponseBody
    @ApiOperation(value = "扣减库存",tags={"仓库API"})
    public void deduct(String commodityCode,int count){
        storageService.deduct(commodityCode,count);
    }

    @RequestMapping("/save")
    @ResponseBody
    public boolean save(String commodityCode, int count){
        return storageService.save(commodityCode,count);
    }

    @RequestMapping("/queryById")
    @ResponseBody
    public StorageTbl queryById(Integer id){
        return storageService.selectByCommodityCode(id);
    }

    @RequestMapping("/subQuery")
    @ResponseBody
    public List<StorageTbl> subQuery(Integer id){
        return storageService.subQuery();
    }

}
