package com.lt.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author lucine
 * @version 1.0 2021/1/17 18:20
 */
@Service
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId,Integer count);
}
