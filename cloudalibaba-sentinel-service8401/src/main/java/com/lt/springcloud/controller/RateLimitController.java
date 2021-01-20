package com.lt.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lt.springcloud.entities.CommonResult;
import com.lt.springcloud.entities.Payment;
import com.lt.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2021/1/12 20:40
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource")
    public CommonResult testHotKey(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }

    public CommonResult handleExcetion(BlockException e){
        return new CommonResult(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/testMyhandler")
    @SentinelResource(value = "testMyhandleraa",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler ="handleException2")
    public CommonResult testMyhandler(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }
}
