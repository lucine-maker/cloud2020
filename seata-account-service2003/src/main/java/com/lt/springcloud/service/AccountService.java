package com.lt.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lucine
 * @version 1.0 2021/1/17 18:50
 */
public interface AccountService {

    /**
     * 扣减账户
     * @param useId 用户id
     * @param money 花费金额
     */
    void decrease(@Param("userId") Long useId , @Param("money") BigDecimal money);
}
