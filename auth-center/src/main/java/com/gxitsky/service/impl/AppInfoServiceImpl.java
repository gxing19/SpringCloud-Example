package com.gxitsky.service.impl;

import com.gxitsky.entity.AppInfo;
import com.gxitsky.entity.AuthRequest;
import com.gxitsky.service.AppInfoService;
import org.springframework.stereotype.Service;

/**
 * @name: AppInfoServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:45
 **/
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Override
    public AppInfo queryAppInfo(AuthRequest authRequest) {
        //便于测试
        return new AppInfo().setId(1001);
    }
}