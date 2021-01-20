package com.lt.springcloud.service;

import com.lt.springcloud.domain.Order;

/**
 * @author lucine
 * @version 1.0 2021/1/17 16:32
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
