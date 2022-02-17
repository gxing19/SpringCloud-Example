package com.gxitsky.service.impl;

import com.gxitsky.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @name: UserInterfaceHystrixFactory
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:52
 **/
@Component
public class UserServiceHystrix implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public String getUser(HashMap<String, Integer> age) {
                return throwable.getMessage();
            }
        };
    }
}
