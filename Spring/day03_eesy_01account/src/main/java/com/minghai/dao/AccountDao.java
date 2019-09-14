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

    /**
     * 根据名称查询账户
     * @param name
     * @return 如果有唯一的结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就抛异常
     */
    Account findAccountByName(String name);
}
