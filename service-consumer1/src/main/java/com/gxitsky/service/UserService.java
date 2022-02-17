package com.gxitsky.service;

import com.gxitsky.common.config.FeignCustomConfig;
import com.gxitsky.service.impl.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * @name: UserService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:46
 **/
@FeignClient(name = "${service.application.name.user}", path = "/user",
        fallbackFactory = UserServiceHystrix.class, configuration = FeignCustomConfig.class)
public interface UserService {

    @GetMapping("/getUser")
    String getUser(@SpringQueryMap HashMap<String, Integer> age);
}
