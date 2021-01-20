package com.lt.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lucine
 * @version 1.0 2021/1/17 16:28
 */
@Configuration
@MapperScan({"com.lt.springcloud.dao"})
public class MyBatisConfig {


}
