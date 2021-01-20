package com.lt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lucine
 * @version 1.0 2021/1/17 16:20
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动装配
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMainApp2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class,args);
    }
}
