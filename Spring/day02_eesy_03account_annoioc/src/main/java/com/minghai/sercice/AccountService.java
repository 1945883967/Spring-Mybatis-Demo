package com.minghai.sercice;

import com.minghai.domain.Account;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:33
 * 账户的业务层接口
 */
public interface AccountService {
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
