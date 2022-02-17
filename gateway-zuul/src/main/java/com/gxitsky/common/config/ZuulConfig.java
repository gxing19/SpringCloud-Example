package com.gxitsky.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: ZuulConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-03 15:27
 **/

@Configuration
public class ZuulConfig {

    /*@Bean
    public CustomPreIpFilter customPreIpFilter() {
        return new CustomPreIpFilter();
    }*/

    /*
    @Bean
    public QueryParamPreFilter queryParamPreFilter(){
        return new QueryParamPreFilter();
    }*/

    /*@Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }*/

    @Bean
    public TokenAuthPreFilter tokenAuthPreFilter(){
        return new TokenAuthPreFilter();
    }
}
