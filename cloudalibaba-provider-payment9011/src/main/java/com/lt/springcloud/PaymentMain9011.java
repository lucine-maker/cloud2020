package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lucine
 * @version 1.0 2021/1/9 22:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9011 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9011.class,args);
    }
}
