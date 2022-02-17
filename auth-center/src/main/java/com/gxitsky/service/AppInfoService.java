package com.gxitsky.service;

import com.gxitsky.entity.AppInfo;
import com.gxitsky.entity.AuthRequest;

/**
 * @name: AuthService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:45
 **/
public interface AppInfoService {
    
    /**
    * @desc: 用户认证
    * @author: gxing
    * @date: 2019/5/27 14:48
    * @param: [authQuery]
    * @return: void
    **/
    AppInfo queryAppInfo(AuthRequest authQuery);
}
