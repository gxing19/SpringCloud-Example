package com.springcloud.service.consumer1.common.config;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: FeignCustomConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-26 17:25
 **/
@Configuration
public class FeignCustomConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Request.Options options(){
        return new Request.Options(5000, 10000);
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "123456");
    }
}