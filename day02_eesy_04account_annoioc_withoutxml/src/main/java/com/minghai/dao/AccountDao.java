package com.minghai.dao;

import com.minghai.domain.Account;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:40
 * 账户的持久层接口
 */
public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccount(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account );

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
