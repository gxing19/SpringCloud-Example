package com.gxitsky.service.impl;

import com.gxitsky.service.FeignInterface;
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
    public String instanceInfo() {
        return "fail：调用失败，执行回退";
    }
}