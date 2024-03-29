package com.gxitsky.controller;

import com.gxitsky.entity.CommonProperties;
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
public class PropertyController {

    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private Environment environment;

    @GetMapping("/property")
    public String refreshProperties(){
        String envAppId = environment.getProperty("common.properties.app-id");
        return commonProperties + "-----" + envAppId;
    }
}