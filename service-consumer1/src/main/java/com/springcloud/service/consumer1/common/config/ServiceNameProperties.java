package com.springcloud.service.consumer1.common.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @name: ServiceNameProperties
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-27 11:20
 **/
@Configuration
@ConfigurationProperties(prefix = "service.application.name")
public class ServiceNameProperties {

    private String sakilaService;

}