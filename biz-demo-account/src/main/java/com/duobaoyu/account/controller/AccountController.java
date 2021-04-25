package com.duobaoyu.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duobaoyu.account.service.AccountService;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/debit")
    public void debit(String userId, Integer money) {
        accountService.debit(userId, money);
    }
}
