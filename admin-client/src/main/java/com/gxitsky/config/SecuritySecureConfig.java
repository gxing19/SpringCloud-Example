package com.gxitsky.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @name: SecuritySecureConfig
 * @desc: 忽略监控端点的跨站伪造请求保护
 * @author: gxing
 * @date: 2019-06-04 18:15
 **/
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/actuator/**");
    }
}
