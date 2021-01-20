package com.lt.springcloud.dao;

import com.lt.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lucine
 * @version 1.0 2021/1/17 16:31
 */
public interface OrderDao {

    /**
     * 1 新建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     * @param userId
     * @param status
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}