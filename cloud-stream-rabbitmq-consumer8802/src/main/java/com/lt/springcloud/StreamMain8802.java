package com.lt.springcloud;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lucine
 * @version 1.0 2021/1/3 14:24
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class StreamMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMain8802.class,args);
    }
}
