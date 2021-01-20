package com.lt.springcloud.controller;

import com.lt.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2020/12/19 22:22
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id ){
        String result = paymentHystrixService.PaymentInfo_OK(id);
        return result;
    }



    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
    })
    public String PaymentInfo_timeout(@PathVariable("id") Integer id ){
//        int age =10/0;
        String result = paymentHystrixService.PaymentInfo_timeout(id);
        return result;
    }





    public String paymentTimeOutFallbackMethod(Integer id){
        return "消费方80：，对方支付系统繁忙，请稍后再试，或者运行出错。";
    }

    public String paymentGlobalFallbackMethod(){
        return "Global :全局兜底方法返回";
    }

}
