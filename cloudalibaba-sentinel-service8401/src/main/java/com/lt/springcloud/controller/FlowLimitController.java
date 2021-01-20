package com.lt.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2021/1/12 20:40
 */
@RestController
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA(){
        return "------A";
    }


    @GetMapping("/testb")
    public String testB(){
        return "------B";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler ="deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value ="p2",required = false) String p2){
        return "testHotKey 返回";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "deal_testHotKey 返回";
    }
}
