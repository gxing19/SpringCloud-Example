package com.springcloud.service.consumer1.common.component.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @name: RestTemplateInterceptor
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-31 15:13
 **/
/*
public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        HttpHeaders headers = request.getHeaders();
//        headers.add("JwtId", System.getProperty("jwtId"));
//        headers.add("Authorization", System.getProperty("token"));
        headers.add("JwtId", "123456789");
        headers.add("Authorization", "abcdefghijklmn");

        return execution.execute(request, body);
    }
}*/
