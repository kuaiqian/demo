package com.duobaoyu.account.service;

/**
 * @author FS001338
 * @date 2020/11/26
 */
public interface AccountService {

    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);
}
