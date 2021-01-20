package com.lt.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2021/1/9 22:16
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/nacos/{id}")
    public String echo(@PathVariable("id") String id) {
        return "Hello Nacos Discovery " + id +"serverPort :"+serverPort;
    }

}
