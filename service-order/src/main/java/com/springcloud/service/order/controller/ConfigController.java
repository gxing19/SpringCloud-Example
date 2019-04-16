package com.springcloud.service.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: ConfigController
 * @desc: 配置属性Controller
 * @author: gxing
 * @date: 2019-04-15 16:14
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private Environment environment;

    @GetMapping("/refresh")
    public String refreshProperties(){
        String appId = environment.getProperty("common.properties.app-id");
        return appId;
    }
}