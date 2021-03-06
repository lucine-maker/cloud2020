package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lucine
 * @version 1.0 2020/12/12 13:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006 {

    public static void main(String[] args){
        SpringApplication.run(Payment8006.class,args);

    }
}
