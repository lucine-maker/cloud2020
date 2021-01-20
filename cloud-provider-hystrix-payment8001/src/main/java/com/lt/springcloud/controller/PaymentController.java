package com.lt.springcloud.controller;

import com.lt.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2020/12/19 20:35
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id ){

        String result = paymentService.paymentInfo_OK(id);
        log.info("****result:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_timeout(@PathVariable("id") Integer id ){

        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("****result:"+result);
        return result;
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("****result:"+s);
        return s;
    }
}
