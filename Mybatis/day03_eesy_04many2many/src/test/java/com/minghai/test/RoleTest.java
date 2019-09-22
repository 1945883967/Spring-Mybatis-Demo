package com.minghai.test;

import com.minghai.dao.IRoleDao;
import com.minghai.domain.Role;
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

public class RoleTest {
    private InputStream in = null;
    IRoleDao roleDao = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        // 使用工厂对象创建dao
        roleDao = sqlSession.getMapper(IRoleDao.class);

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
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("-------------每个用户的信息--------------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
