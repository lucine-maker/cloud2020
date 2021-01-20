package com.lt.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lucine
 * @version 1.0 2020/12/20 17:38
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String PaymentInfo_OK(Integer id) {
        return "PaymentInfo_OK 的自定义默认返回兜底";
    }

    @Override
    public String PaymentInfo_timeout(Integer id) {
        return "PaymentInfo_timeout 的自定义默认返回兜底";
    }

//    @Override
//    public String paymentCircuitBreaker(Integer id) {
//        return null;
//    }
}
