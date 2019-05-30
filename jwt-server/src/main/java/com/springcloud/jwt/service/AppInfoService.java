package com.springcloud.jwt.service;

import com.springcloud.jwt.entity.AppInfo;
import com.springcloud.jwt.entity.query.AuthQuery;

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
    AppInfo queryAppInfo(AuthQuery authQuery);
}
