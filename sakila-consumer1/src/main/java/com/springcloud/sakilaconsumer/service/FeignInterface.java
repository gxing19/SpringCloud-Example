package com.springcloud.sakilaconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: FeignInterface
 * @desc: Feign客户端接口
 * @author: gxing
 * @date: 2019-03-25 10:37
 **/
@FeignClient(name = "sakila-service1",path = "/service")
public interface FeignInterface {

    @GetMapping("/home")
    public String callHome();
}
