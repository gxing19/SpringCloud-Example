package com.springcloud.service.consumer1.service.impl;

import com.springcloud.service.consumer1.service.FeignInterface;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @name: FeignInterfaceHystrixFactory
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-27 15:34
 **/
@Component
public class FeignInterfaceHystrixFactory implements FallbackFactory<FeignInterface> {
    @Override
    public FeignInterface create(Throwable throwable) {
        return new FeignInterface() {
            @Override
            public String callHome() {
                return throwable.getMessage();
            }
        };
    }
}