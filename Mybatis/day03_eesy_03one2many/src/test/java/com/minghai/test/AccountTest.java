package com.minghai.test;

import com.minghai.dao.IAccountDao;
import com.minghai.domain.Account;
import com.minghai.domain.AccountUser;
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
import java.util.Arrays;
import java.util.List;

public class AccountTest {
    private InputStream in = null;
    IAccountDao accountDao = null;

    // 用于在测试方法执行之前执行
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        // 使用工厂对象创建dao
        accountDao = sqlSession.getMapper(IAccountDao.class);

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
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    /**
     * 测试查询所有，并包含用户名和地址信息
     */
    @Test
    public void findAllAccount() throws IOException {
        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser au : aus) {
            System.out.println(au);
        }
    }


}
