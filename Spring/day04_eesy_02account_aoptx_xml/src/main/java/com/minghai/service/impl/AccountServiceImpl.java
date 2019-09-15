package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import com.minghai.service.AccountService;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:39
 * 账户的业务层实现类
 *
 * 事务控制应该是在业务层
 */
public class AccountServiceImpl implements AccountService{


    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


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

    public void transfer(String scourceName, String targetName, Float money) {
        System.out.println("开始执行");
        // 2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(scourceName);
            // 2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 2.3.转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            // 2.5.更新转出账户
            accountDao.updateAccount(source);

            int i = 10/0;

            // 2.6.更新转入账户
            accountDao.updateAccount(target);
    }
}
