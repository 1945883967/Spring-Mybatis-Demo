package com.minghai.dao.impl;

import com.minghai.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author minghai
 * @date 2019/6/30 - 19:09
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao{

    public void saveAccount(){
        System.out.println("保存账户2222222");
    }



}
