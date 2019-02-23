package com.springcloud.sakilaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplateOne;

    @Autowired
    private RestTemplate restTemplateTwo;


    @GetMapping("/callHello")
    public String callHello() {

        //直接调用服务接口
        String url1 = "http://localhost:8081/sakila/home";

        //通过Eureka来调用服务接口
        String url2 = "http://sakila-service/sakila/home";

        String str1 = restTemplateOne.getForObject(url1, String.class);
        String str2 = restTemplateTwo.getForObject(url2, String.class);
        return str1 + "---" + str2;
    }
}
