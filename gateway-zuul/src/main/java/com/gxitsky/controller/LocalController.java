package com.gxitsky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: ZuulController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-03 17:33
 **/
@RestController
@RequestMapping("/local")
public class LocalController {

    @GetMapping("/zuul/{id}")
    public String localZuul(@PathVariable String id){
        return "Local Zuul + " + id;
    }
}