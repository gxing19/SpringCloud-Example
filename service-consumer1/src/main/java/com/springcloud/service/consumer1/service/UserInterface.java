package com.springcloud.service.consumer1.service;

import com.springcloud.service.consumer1.common.config.FeignCustomConfig;
import com.springcloud.service.consumer1.service.impl.UserInterfaceHystrixFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: UserInterface
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:46
 **/
@FeignClient(name = "${service.application.name.user}", path = "/user",
        fallbackFactory = UserInterfaceHystrixFactory.class, configuration = FeignCustomConfig.class)
public interface UserInterface {

    @GetMapping("/getUser")
    String getUser();
}
