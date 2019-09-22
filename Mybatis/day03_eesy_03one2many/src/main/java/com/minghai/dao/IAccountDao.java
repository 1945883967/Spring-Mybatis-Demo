package com.minghai.dao;

import com.minghai.domain.Account;
import com.minghai.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有，同时还要获取当前用户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser>  findAllAccount();
}
