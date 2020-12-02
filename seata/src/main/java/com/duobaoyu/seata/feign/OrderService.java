package com.duobaoyu.seata.feign;

import com.duobaoyu.seata.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@FeignClient(name = "order", url = "http://localhost:10002")
public interface OrderService {

    @PostMapping("/create")
    public Order create(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam Integer count);
}
