package com.minghai.sercice.impl;

import com.minghai.dao.AccountDao;
import com.minghai.domain.Account;
import com.minghai.sercice.AccountService;
import com.minghai.utils.TranscationManager;

import java.util.List;

/**
 * @author minghai
 * @date 2019/7/2 - 9:39
 * 账户的业务层实现类
 *
 * 事务控制应该是在业务层
 */
public class AccountServiceImpl_OLD implements AccountService{


    private AccountDao accountDao;
    private TranscationManager txManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TranscationManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
            return accounts;
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            txManager.release();
        }
    }

    public Account findAccount(Integer accountId) {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            Account account = accountDao.findAccount(accountId);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
            return account;
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            // 6.释放连接
            txManager.release();
        }

    }

    public void saveAccount(Account account) {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            accountDao.saveAccount(account);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
        }finally {
            // 6.释放连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            accountDao.updateAccount(account);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
        }finally {
            // 6.释放连接
            txManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            accountDao.deleteAccount(accountId);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
        }finally {
            // 6.释放连接
            txManager.release();
        }

    }

    public void transfer(String scourceName, String targetName, Float money) {
        try{
            // 1.开启事务
            txManager.beginTranscation();
            // 2.执行操作
            // 2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(scourceName);
            // 2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 2.3.转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            // 2.5.更新转出账户
            accountDao.updateAccount(source);

            int i = 10/0;
            // 2.6.更新转入账户
            accountDao.updateAccount(target);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
        }catch (Exception e){
            // 5.回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            // 6.释放连接
            txManager.release();
        }


    }
}
