package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lucine
 * @version 1.0 2021/1/15 23:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain84.class,args);
    }
}
