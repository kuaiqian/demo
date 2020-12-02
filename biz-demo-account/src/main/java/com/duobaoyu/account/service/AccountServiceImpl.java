package com.duobaoyu.account.service;

import com.duobaoyu.mybatis.mapper.AccountTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author FS001338
 * @date 2020/11/26
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountTblMapper accountTblMapper;

    @Override
    public void debit(String userId, int money) {
        int debit = accountTblMapper.debit(userId, money);
    }
}
