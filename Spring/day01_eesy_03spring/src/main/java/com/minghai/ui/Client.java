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
     * 获取spring的IOC核心容器，并根据ID获取对象
     *
     * ApplicationContext 的三个常用实现类
     *          ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载不了
     *          FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *          AnnotationfigApplicationContext：它是用于读取注解创建容器的
     *
     * 核心容器的两个接口引发的出的问题：
     * ApplicationContext:  单例对象适用
     *      它在构建核心容器时，创建对象采取的策略是立即加载的方式，也就是说，只要一读取配置文件马上就创建配置文件中配置的对象。
     * BeanFactory：        多例对象适用
     *      它在创建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说什么时候根据ID获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据ID获取bean对象
//        AccountService as = (AccountService) ac.getBean("accountService");
//        AccountService add = ac.getBean("accountService",AccountService.class);
//        System.out.println(as);
//        System.out.println(add);
//        as.saveAccount();

       // -------BeanFactory----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
   }
}
