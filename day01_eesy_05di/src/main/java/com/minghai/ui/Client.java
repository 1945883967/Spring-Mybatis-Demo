package com.minghai.ui;

import com.minghai.service.AccountService;
import com.minghai.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @author minghai
 * @date 2019/6/30 - 19:10
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据ID获取bean对象
//        AccountService as = (AccountService) ac.getBean("accountService1");
//        AccountService as = (AccountService) ac.getBean("accountService2");
        AccountService as = (AccountService) ac.getBean("accountService3");
        as.saveAccount();

   }
}
