package com.minghai.dao;

import com.minghai.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 *
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户,并查询用户的所有账户
     * @return
     */
    @Select(value = "select * from user")
    @Results(id = "userMap", value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.minghai.dao.IAccount.findAccountById",
                                 fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 查询一个用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap(value={"userMap"})
//    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

}
