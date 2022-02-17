package com.gxitsky.service;

import com.gxitsky.bean.ResultBean;
import com.gxitsky.entity.query.AuthQuery;
import com.gxitsky.service.impl.AuthServiceHystrix;
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