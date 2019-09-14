package com.minghai.text;

import com.minghai.domain.Account;
import com.minghai.sercice.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 10:29
 * 使用junit单元测试，测试我们配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account :accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        Account account = as.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        Account account = new Account();
        account.setName("tom");
        account.setMoney(123f);
        as.saveAccount(account);

    }

    @Test
    public void testUpdate(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        Account account = as.findAccount(4);
        account.setMoney(26546f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        as.deleteAccount(4);
    }

}
