package com.lt.springcloud.controller;

import com.lt.springcloud.entities.CommonResult;
import com.lt.springcloud.entities.Payment;
import com.lt.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if(result > 0 ){
            return  new CommonResult(200,"插入数据库成功 ->serverPort:"+serverPort,result);
        }else{
            return  new CommonResult(444,"插入数据库失败->serverPort:"+serverPort,null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        if(payment !=null ){
            return  new CommonResult(200,"查询结果成功->serverPort:"+serverPort,payment);
        }else{
            return  new CommonResult(444,"没有对应记录->serverPort:"+serverPort+" -》》id："+id,null);
        }
    }

    @GetMapping("/payment/discovert")
    public Object getDiscoveryClient(){

        List<String> services = discoveryClient.getServices();
        for (String server:
        services) {
            log.info("***element"+server);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:
        instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public  String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
//            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping(value = "/payment/zipkin")
    public String getPaymentZipkin(){
        return "hi ,getPaymentZipkin";
    }
}
