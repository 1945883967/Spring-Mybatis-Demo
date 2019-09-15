package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import com.minghai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:39
 * 账户的业务层实现类
 *
 * 事务控制应该是在业务层
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)// 只读型事务配置
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    // 需要的是读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

}
