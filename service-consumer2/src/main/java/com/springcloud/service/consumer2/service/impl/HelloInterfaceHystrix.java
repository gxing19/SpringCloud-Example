package com.springcloud.service.consumer2.service.impl;

import com.springcloud.service.consumer2.service.HelloInterface;
import org.springframework.stereotype.Service;

/**
 * @name: FeignInterfaceHystrixFactory
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-29 09:45
 **/
@Service
public class HelloInterfaceHystrix implements HelloInterface {

    @Override
    public String getHello() {
        return "getHello fail: 执行回退";
    }
}