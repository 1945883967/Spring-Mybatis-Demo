package com.minghai.dao;

import com.minghai.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void svaeUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id = #{id}")
    void updateUser(User user);


    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 查询一个用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName1(String username);

    /**
     * 查询所有的记录数
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();
}
