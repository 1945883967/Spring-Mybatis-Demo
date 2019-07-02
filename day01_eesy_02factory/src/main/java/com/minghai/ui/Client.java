package com.minghai.ui;

import com.minghai.factory.BeanFactory;
import com.minghai.service.AccountService;
import com.minghai.service.impl.AccountServiceImpl;

/**
 * @author minghai
 * @date 2019/6/30 - 19:10
 */
public class Client {
    public static void main(String[] args) {
//        AccountService as = new AccountServiceImpl();
       for (int i =0; i<5;i++){
           AccountService as = (AccountService) BeanFactory.getBean("accountService");
           System.out.println(as);
           as.saveAccount();
       }
    }
}
