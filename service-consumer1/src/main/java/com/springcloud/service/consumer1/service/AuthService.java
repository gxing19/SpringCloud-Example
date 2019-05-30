package com.springcloud.service.consumer1.service;

import com.springcloud.service.consumer1.entity.query.AuthQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name: AuthService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:56
 **/
public interface AuthService {
    
    String getToken(AuthQuery authQuery);

    String getToken(AuthQuery authQuery, HttpServletRequest request, HttpServletResponse response);
}