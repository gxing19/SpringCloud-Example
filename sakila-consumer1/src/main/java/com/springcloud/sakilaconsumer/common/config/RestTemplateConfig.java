package com.springcloud.sakilaconsumer.common.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * RestTemplate配置类
 */
@Configuration
public class RestTemplateConfig {

    @Bean(name = "restTemplateOne")
    public RestTemplate restTemplateOne() {
        //设置超时时间,毫秒
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(1000)).setReadTimeout(Duration.ofMillis(1000)).build();
    }

    @Bean(name = "restTemplateTwo")
    @LoadBalanced
    public RestTemplate restTemplateTwo(){
        //设置超时时间,毫秒
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(1000)).setReadTimeout(Duration.ofMillis(1000)).build();
    }
}
