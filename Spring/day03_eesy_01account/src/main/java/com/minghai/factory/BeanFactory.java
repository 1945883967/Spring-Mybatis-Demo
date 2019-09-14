package com.minghai.factory;

import com.minghai.sercice.AccountService;
import com.minghai.utils.TranscationManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象工厂
 */
public class BeanFactory {
    private AccountService accountService;
    private TranscationManager txManager;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TranscationManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取service的代理对象
     * @return
     */
    public AccountService getAccountService() {
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object retValue = null;
                        try{
                            // 1.开启事务
                            txManager.beginTranscation();
                            // 2.执行操作
                            retValue = method.invoke(accountService,args);
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
                        return retValue;
                    }
                });
        return accountServiceProxy;
    }
}
