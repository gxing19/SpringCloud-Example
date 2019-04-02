package com.springcloud.service.consumer2.controller;

import com.springcloud.service.consumer2.service.HelloInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer2")
public class HelloController {

    @Autowired(required = false)
    private HelloInterface helloInterface;

//    @HystrixCommand(fallbackMethod = "defaultCallHome")
    @GetMapping("/getHello")
    public String getHello() {
        String str = helloInterface.getHello();
        return str;
    }

    public String defaultCallHome() {
        return "getHello fail：调用失败，执行回退";
    }

}
