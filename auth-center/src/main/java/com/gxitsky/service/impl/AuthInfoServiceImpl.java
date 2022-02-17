package com.gxitsky.service.impl;

import com.gxitsky.entity.AuthInfo;
import com.gxitsky.entity.AuthRequest;
import com.gxitsky.service.AuthInfoService;
import org.springframework.stereotype.Service;

/**
 * @name: AuthInfoServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:45
 **/
@Service
public class AuthInfoServiceImpl implements AuthInfoService {

    @Override
    public AuthInfo query(AuthRequest authRequest) {
        //便于测试
        return new AuthInfo().setId(1001);
    }
}