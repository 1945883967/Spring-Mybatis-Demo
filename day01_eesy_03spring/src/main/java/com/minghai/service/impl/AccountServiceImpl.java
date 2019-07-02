package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.dao.impl.AccountDaoImpl;
import com.minghai.service.AccountService;

/**
 * @author minghai
 * @date 2019/6/30 - 19:02
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

     AccountDao accountDao = new AccountDaoImpl();

     public AccountServiceImpl(){
         System.out.println("AccountServiceImpl对象创建了");
     }

    public  void saveAccount(){
        accountDao.saveAccount();
    }
}
