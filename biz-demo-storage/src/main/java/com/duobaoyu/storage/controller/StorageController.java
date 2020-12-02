package com.duobaoyu.storage.controller;

import com.duobaoyu.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FS001338
 * @date 2020/11/26
 */

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/deduct")
    @ResponseBody
    public void deduct(String commodityCode,int count){
        storageService.deduct(commodityCode,count);
    }

}
