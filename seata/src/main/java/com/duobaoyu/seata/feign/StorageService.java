package com.duobaoyu.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FS001338
 * @date 2020/11/27
 */
@FeignClient(name = "storage", url = "http://localhost:10001")
public interface StorageService {

    @RequestMapping("/deduct")
    public void deduct(@RequestParam String commodityCode, @RequestParam int count);

}
