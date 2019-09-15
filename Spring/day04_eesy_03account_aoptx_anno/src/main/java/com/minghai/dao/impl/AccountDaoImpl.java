package com.minghai.dao.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import com.minghai.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:44
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;


    public List<Account> findAllAccount() {
       try{
           return runner.query(connectionUtils.getThradConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    public Account findAccount(Integer accountId) {
        try{
            return runner.query(connectionUtils.getThradConnection(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
             runner.update(connectionUtils.getThradConnection(),"insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThradConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            runner.update(connectionUtils.getThradConnection(),"delete from  account where id=?",accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String name) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThradConnection(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),name);
            if(accounts == null || accounts.size()==0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }

            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
