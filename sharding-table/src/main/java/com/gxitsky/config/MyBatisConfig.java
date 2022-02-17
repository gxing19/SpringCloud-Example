package com.gxitsky.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @name: MybatisConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 15:39
 **/
@Configuration
@MapperScan(value = "com.shardingjdbc.shardingtable.mapper")
public class MyBatisConfig {
}