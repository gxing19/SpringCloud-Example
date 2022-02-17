package com.gxitsky.service;

import com.gxitsky.common.config.FeignCustomConfig;
import com.gxitsky.service.impl.FeignInterfaceHystrixFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: FeignInterface
 * @desc: Feign客户端接口
 * @author: gxing
 * @date: 2019-03-25 10:37
 **/
@FeignClient(name = "${service.application.name.user}", path = "/instance",
        fallbackFactory = FeignInterfaceHystrixFactory.class, configuration = FeignCustomConfig.class)
public interface FeignInterface {

    @GetMapping("/instanceInfo")
    String instanceInfo();
}
