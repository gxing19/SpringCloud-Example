package com.springcloud.service.consumer1.common.config;

import com.springcloud.service.consumer1.common.component.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
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

    /**
     * 日志级别
     * @return
     */
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

    /**
     * 创建 Feign 请求拦截器，在发送请注前设置认证的 Token
     * 各个微服务将 Token 设置到环境变量来达到通用目的
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }
}