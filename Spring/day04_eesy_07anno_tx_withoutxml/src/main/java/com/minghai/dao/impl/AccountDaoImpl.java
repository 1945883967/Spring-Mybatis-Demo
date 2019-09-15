package com.minghai.dao.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类    如果使用注解开发，则此情况下不能用注解注入JdbcTempalte
 */
@Repository("accountDao")
public class AccountDaoImpl  implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcDaoSupport;


    public Account findAccountById(Integer accountId) {
        List<Account> accounts =jdbcDaoSupport.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.get(0);
    }

    public Account findAccountByName(String AccountName) {
        List<Account> accounts = jdbcDaoSupport.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), AccountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcDaoSupport.update("update account set name = ?,money = ? where id = ? ",account.getName(),account.getMoney(),account.getId());
    }
}
