package com.minghai.dao;

import com.minghai.domain.User;

import java.util.List;

/**
 * 用户持久层的接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     *  保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(int userId);

    /**
     * 根据名称模糊插叙用户
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findCount();

}
