package com.minghai.factory;

import com.minghai.service.AccountService;
import com.minghai.service.impl.AccountServiceImpl;

/**
 * @author minghai
 * @date 2019/6/30 - 22:41
 */
public class Staticfactory {
    public static  AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
