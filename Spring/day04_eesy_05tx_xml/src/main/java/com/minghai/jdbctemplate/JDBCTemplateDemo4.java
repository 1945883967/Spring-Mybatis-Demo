package com.minghai.jdbctemplate;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/*

JdbcTemplate的基本用法
 */
public class JDBCTemplateDemo4 {
    public static void main(String[] args) {
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取对象
        AccountDao accountDao = ac.getBean("accountDaoImpl",AccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(3000000f);
        accountDao.updateAccount(account);
    }
}
