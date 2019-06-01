package com.springcloud.service.consumer1.common.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: FeignAuthConfig
 * @desc: 调用认证服务Feign 配置
 * @author: gxing
 * @date: 2019-05-31 09:11
 **/
/*
@Configuration
public class FeignAuthConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Request.Options options(){
        return new Request.Options(5000, 10000);
    }
}*/
