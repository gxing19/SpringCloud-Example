package com.springcloud.sakilaconsumer2.service;

import com.springcloud.sakilaconsumer2.service.impl.HelloInterfaceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: FeignInterface
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-29 09:43
 **/
@FeignClient(name = "sakila-service1", path = "/service", fallback = HelloInterfaceHystrix.class)
public interface HelloInterface {

    @GetMapping("/hello")
    String getHello();
}
