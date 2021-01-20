package com.lt.springcloud;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lucine
 * @version 1.0 2021/1/3 13:42
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class StreamMQMain8801 {

    public static void main(String [] args){
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
