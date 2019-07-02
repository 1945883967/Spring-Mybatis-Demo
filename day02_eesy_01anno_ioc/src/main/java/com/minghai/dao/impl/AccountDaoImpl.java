package com.minghai.dao.impl;

import com.minghai.dao.AccountDao;
import com.minghai.service.AccountService;
import org.springframework.stereotype.Repository;

/**
 * @author minghai
 * @date 2019/6/30 - 19:09
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao{

    public void saveAccount(){
        System.out.println("保存账户1111111");
    }



}
