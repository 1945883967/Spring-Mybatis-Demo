package com.minghai.sercice.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import com.minghai.sercice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:39
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;



    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccount(Integer accountId) {

        return accountDao.findAccount(accountId);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
