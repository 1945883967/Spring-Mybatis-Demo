package com.minghai.dao;

import com.minghai.domain.QueryVo;
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
     *  根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的ids查询用户
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

}
