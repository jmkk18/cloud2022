package com.jm.cloudalibaba.service.impl;

import com.jm.cloudalibaba.dao.AccountDao;
import com.jm.cloudalibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    public static final Logger LOGGER= LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long id, BigDecimal money) {
        LOGGER.info("----->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
//        try{
//            TimeUnit.SECONDS.sleep(20);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        accountDao.decrease(id,money);
        LOGGER.info("----->account-service中扣减账户余额结束");
    }
}
