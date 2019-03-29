package com.springcloud.sakilaconsumer.service.impl;

import com.springcloud.sakilaconsumer.service.FeignInterface;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @name: FeignInterfaceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-03-27 15:13
 **/
@Service
public class FeignInterfaceHystrix implements FeignInterface {

    @Override
    public String callHome() {
        return "fail：调用失败，执行回退";
    }
}