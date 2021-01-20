package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lucine
 * @version 1.0 2020/12/22 10:29
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527 {

    public static void main(String[] args){
        SpringApplication.run(Gateway9527.class,args);
    }

}
