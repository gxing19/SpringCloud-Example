package com.springcloud.service.consumer1.service.impl;

import com.springcloud.service.consumer1.service.UserInterface;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @name: UserInterfaceHystrixFactory
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:52
 **/
@Component
public class UserInterfaceHystrixFactory implements FallbackFactory<UserInterface> {
    @Override
    public UserInterface create(Throwable throwable) {
        return new UserInterface() {
            @Override
            public String getUser() {
                return throwable.getMessage();
            }
        };
    }
}
