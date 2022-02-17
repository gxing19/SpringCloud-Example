package com.gxitsky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: HelloController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-29 09:54
 **/
@RestController
@RequestMapping("/service")
public class HelloController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
}