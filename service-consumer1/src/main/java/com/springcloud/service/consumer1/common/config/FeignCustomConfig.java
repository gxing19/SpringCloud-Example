package com.springcloud.service.consumer1.common.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @name: FeignCustomConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-26 17:25
 **/
@Component
public class FeignCustomConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Request.Options options(){
        return new Request.Options(5000, 10000);
    }

    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "123456");
    }*/
}