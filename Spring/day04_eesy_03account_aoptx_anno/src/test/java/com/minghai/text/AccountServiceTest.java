package com.minghai.text;

import com.minghai.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author minghai
 * @date 2019/7/2 - 10:29
 * 使用junit单元测试，测试我们配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {


    @Autowired
    private AccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }

}
