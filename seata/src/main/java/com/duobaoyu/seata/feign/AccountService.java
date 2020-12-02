package com.duobaoyu.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author FS001338
 * @date 2020/11/27
 */
@FeignClient(name = "account",url = "http://localhost:10003")
public interface AccountService {

    @PostMapping("/debit")
    public void debit(@RequestParam String userId, @RequestParam Integer money);
}
