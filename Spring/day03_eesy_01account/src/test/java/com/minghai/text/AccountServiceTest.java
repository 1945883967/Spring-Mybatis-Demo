package com.minghai.text;

import com.minghai.domain.Account;
import com.minghai.sercice.AccountService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 10:29
 * 使用junit单元测试，测试我们配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {


    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }

}
