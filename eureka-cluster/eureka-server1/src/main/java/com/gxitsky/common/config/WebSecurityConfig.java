package com.gxitsky.common.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @name: SpringSecurityConfig
 * @desc: SpringSecurity配置类
 * @author: gxing
 * @date: 2019-02-22 10:22
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*httpSecurity.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();*/
        httpSecurity.csrf().ignoringAntMatchers("/eureka/**");
//        super.configure(httpSecurity);
    }
}
