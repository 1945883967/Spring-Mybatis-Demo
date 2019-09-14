package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.dao.impl.AccountDaoImpl;
import com.minghai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author minghai
 * @date 2019/6/30 - 19:02
 * 账户业务层实现类
 *
 * 曾经XML配置
 * <bean id="accountService" class="com.minghai.service.impl.AccountServiceImpl"
 *      scpoe="" init-methos="" destory-methos="">
 *      <property name="" value="" | ref=""></property>
 *  </bean>
 *
 * 用于创建对象的
 *      它们的作用就和在XML配置文件中编写一个<bean></bean>标签功能是一样的
 *       @Component:
 *          作用：作用把当前对象存入spring容器中
 *          属性：
 *              value:用于指定bean的id,当我们不写时，它的默认值是当前类名，且首字母改小写。
 *       @Controller    ：一般 用于表现层
 *       @Service       ：一般用于业务层
 *       @Repository    ：一般用于持久层
 *       以上三个注解他们的作用和属性与Component时一模一样的。
 *       他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 * 用于注入数据的
 *       它们的作用就和在XML中的bean标签中写一个<property></property>标签是一样的
 *       @Autowired
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *                如果Ioc容器中有多个类型匹配时：先根据类型匹配，在根据变量名进行匹配
 *          出现位置：
 *              可以是成员变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了。
 *          Qualifier:
 *              作用：在按照类中注入的基础之上在按照名称注入，他在类类成员注入时不能单独使用。但在给方法参数注入时可以
 *              属性：
 *                  value:用于指定注入bean的id
 *          Resource:
 *              作用：直接按照bean的id注入。他可以独立使用
 *              属性：
 *                  name:用于指定bean的id
 *          Value:
 *              作用：用于注入基本类型和String类型的数据
 *              属性：
 *                  value:用于指定数据的值，它可以使用spring中的SpEl（也就是spring中el表达式）
 *                      SpEl的写法：${表达式}
 * 用于改变作用范围的
 *       它们的作用就和在bean标签中使用scope属性实现的功能是一样的
 *       Scope:
 *          作用：用于指定bean的作用范围   不写默认情况是singleton
 *          属性：
 *              value:指定范围的取值。常用取值：singleton prototype
 *
 * 和生命周期相关的
 *      它们的作用就和在bean标签中使用init-method和destory-method属性是一样的
 *      PreDestory：
 *          作用：用于指定销毁方法
 *      PostConstruct:
 *          作用:用于指定初始化方法
 */
@Component
@Scope("prototype")
public class AccountServiceImpl implements AccountService {
//
     @Autowired()
     @Qualifier("accountDao")
//     @Resource(name = "accountDao1")
     AccountDao accountDao = null;

    @Autowired
    public  void saveAccount(){
        accountDao.saveAccount();
    }
}
