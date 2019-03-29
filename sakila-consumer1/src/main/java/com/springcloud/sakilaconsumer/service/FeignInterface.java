package com.springcloud.sakilaconsumer.service;

import com.springcloud.sakilaconsumer.common.config.FeignCustomConfig;
import com.springcloud.sakilaconsumer.service.impl.FeignInterfaceHystrixFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: FeignInterface
 * @desc: Feign客户端接口
 * @author: gxing
 * @date: 2019-03-25 10:37
 **/
@FeignClient(name = "${service.application.name.sakila-service}", path = "/service",
        fallbackFactory = FeignInterfaceHystrixFactory.class, configuration = FeignCustomConfig.class)
public interface FeignInterface {

    @GetMapping("/home")
    String callHome();
}
