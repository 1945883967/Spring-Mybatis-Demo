package com.minghai.service;

import com.minghai.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    /**
     * 根据ID查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param scourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String scourceName, String targetName, Float money);
}
