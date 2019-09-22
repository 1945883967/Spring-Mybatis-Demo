package com.minghai.dao;

import com.minghai.domain.User;

import java.util.List;

/**
 * 用户持久层的接口
 */
public interface IUserDao {
    /**
     * 查询所有用户,同时获取账户下所有用户的信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(int userId);


}
