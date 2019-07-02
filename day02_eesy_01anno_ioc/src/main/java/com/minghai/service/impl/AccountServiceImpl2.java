package com.minghai.service.impl;

import com.minghai.dao.AccountDao;
import com.minghai.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author minghai
 * @date 2019/6/30 - 19:02
 * 账户业务层实现类
 *
 */
@Component
//@Scope("propotype")
public class AccountServiceImpl2 implements AccountService {
//
//     @Autowired
//     @Qualifier("accountDao")
    @Resource(name = "accountDao1")
    AccountDao accountDao = null;


    public  void saveAccount(){
        accountDao.saveAccount();
    }

    @PostConstruct
    public  void init(){
        System.out.println("初始化方法");
    }

    @PreDestroy
    public  void destory(){
        System.out.println("销毁方法开始了");
    }


}
