package com.minghai.test;

import com.minghai.dao.IUserDao;
import com.minghai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in = null;
    IUserDao userDao = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        // 使用工厂对象创建dao
        userDao = sqlSession.getMapper(IUserDao.class);

    }
    // 用于在测试方法执行之后执行
    @After
    public void destory() throws IOException {
        in.close();
    }

    /**
     * 测试查询所有，
     */
    @Test
    public void findAll() throws IOException {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-------------每个用户的信息--------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


}
