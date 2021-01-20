package com.lt.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lt.springcloud.entities.CommonResult;
import com.lt.springcloud.entities.Payment;
import com.lt.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lucine
 * @version 1.0 2021/1/9 22:39
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") String id) {
        return restTemplate.getForObject(serverURL+"/paymentSQL/"+id,String.class);
    }



    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id ){
        CommonResult<Payment> result=restTemplate.getForObject(serverURL+"/paymentSQL/"+id,CommonResult.class,id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException ，非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException ，没有该条记录，空指针了");
        }
        return result;

    }


    public  CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,null);
        return new CommonResult<>(444,"兜底的handlerFallback 触发"+e.getMessage(),payment);
    }

    public  CommonResult blockHandler(@PathVariable Long id, BlockException e){
        Payment payment = new Payment(id,null);
        return new CommonResult<>(444,"blockHandler -sentinel 限流 触发"+e.getMessage(),payment);
    }


    //+++++ openfeign

    @GetMapping(value = "/consumer/openfeign/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id){
        return paymentService.paymentSQL(id);
    }

}
