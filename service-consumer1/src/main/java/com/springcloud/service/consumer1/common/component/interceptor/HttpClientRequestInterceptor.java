package com.springcloud.service.consumer1.common.component.interceptor;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * @name: HttpClientRequestInterceptor
 * @desc: HttpClient 请求拦截器
 * @author: gxing
 * @date: 2019-05-31 15:43
 **/
/*
public class HttpClientRequestInterceptor implements HttpRequestInterceptor {
    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        request.setHeader("JwtId", System.getProperty("JwtId"));
        request.setHeader("Authorization", System.getProperty("token"));
    }
}*/
