package com.minghai.text;

import com.minghai.domain.Account;
import com.minghai.sercice.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 10:29
 * 使用junit单元测试，测试我们配置
 * spring整合junit的配置
 *      1、导入spring整合junit的jar包（坐标）
 *      2、使用junit提供的一个注解把原有的Main方法替换，替换成spring提供的
 *          @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于XML还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations:指定XML文件的位置，加上classpath关键字，表示在类路径下
 *                  classes:指定注解类所在的位置
 *
 * 当使用spring 5.x版本时，要求junit的jar必须是4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void testFindAll(){


        // 3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account :accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        Account account = as.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        // 1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.获得业务层对象
        AccountService as = ac.getBean("accountService",AccountService.class);

        // 3.执行方法
        as.deleteAccount(4);
    }

}
