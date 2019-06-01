package com.springcloud.service.consumer1.common.component.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @name: FeignBasicAuthRequestInterceptor
 * @desc: Feign 请求拦截器
 * @author: gxing
 * @date: 2019-05-30 11:37
 **/
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("JwtId", System.getProperty("jwtId"));
        requestTemplate.header("Authorization", System.getProperty("token"));
    }
}