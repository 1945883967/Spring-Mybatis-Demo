package com.minghai.dao;

import com.minghai.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param AccountName
     * @return
     */
    Account findAccountByName(String AccountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
