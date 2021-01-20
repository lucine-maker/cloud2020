package com.lt.springcloud.service.iml;

import com.lt.springcloud.dao.AccountDao;
import com.lt.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author lucine
 * @version 1.0 2021/1/17 18:51
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("-->>account-service 中扣减账户余额开始");
        //模拟错误
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
        LOGGER.info("-->>account-service 中扣减账户余额结束");
    }
}
