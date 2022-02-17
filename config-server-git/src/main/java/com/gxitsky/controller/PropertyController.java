package com.gxitsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: PropertyController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-10 18:27
 **/
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private Environment environment;

    @GetMapping("/url")
    public String getUrl(){
        String gitUrl = environment.getProperty("spring.cloud.config.server.git.uri");

        return gitUrl;
    }

}