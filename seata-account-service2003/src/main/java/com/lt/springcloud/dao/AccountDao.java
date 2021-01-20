package com.lt.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author lucine
 * @version 1.0 2021/1/17 18:49
 */
@Mapper
public interface AccountDao {


    void decrease(@Param("userId") Long userId , @Param("money")BigDecimal money);
}
