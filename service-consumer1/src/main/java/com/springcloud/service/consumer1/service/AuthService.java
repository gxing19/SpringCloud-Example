package com.springcloud.service.consumer1.service;

import com.springcloud.commons.bean.ResultBean;
import com.springcloud.service.consumer1.common.config.FeignCustomConfig;
import com.springcloud.service.consumer1.entity.query.AuthQuery;
import com.springcloud.service.consumer1.service.impl.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @name: AuthService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:56
 **/
@FeignClient(name = "${service.application.name.jwt}", path = "/auth",
        fallbackFactory = AuthServiceHystrix.class)
public interface AuthService {

    @PostMapping("/token")
    ResultBean getToken(@SpringQueryMap AuthQuery authQuery);

}