package com.jm.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jm.cloudalibaba.dao"})
public class MyBatisConfig {
}
