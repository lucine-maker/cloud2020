package com.lt.springcloud;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @auth lucine
 * @EnableDiscoveryClient 该注解用于向使用consul或者zookeeper作为注册中心服务
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,DataSourceAutoConfiguration.class})
public class PaymentMain8004 {

    public static void main(String[] args ){
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
