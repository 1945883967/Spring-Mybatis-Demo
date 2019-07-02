package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.dao.impl.AccountDaoImpl;
import com.minghai.factory.BeanFactory;
import com.minghai.service.AccountService;

/**
 * @author minghai
 * @date 2019/6/30 - 19:02
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();
    AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    //private int i = 1;

    public  void saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
