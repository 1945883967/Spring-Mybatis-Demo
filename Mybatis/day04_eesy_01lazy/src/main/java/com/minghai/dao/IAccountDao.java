package com.minghai.dao;

import com.minghai.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有，同时还要获取当前用户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id，查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
