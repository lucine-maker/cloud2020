package com.lt.springcloud.service;

import com.lt.springcloud.entities.CommonResult;
import com.lt.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lucine
 * @version 1.0 2021/1/16 14:59
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回 --PaymentFallbackService ",new Payment(id,"errorSerial")) ;
    }
}
