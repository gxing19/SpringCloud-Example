package com.springcloud.service.consumer1.service.impl;

import com.springcloud.service.consumer1.entity.query.AuthQuery;
import com.springcloud.service.consumer1.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name: AuthServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:56
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplateOne;

    @Override
    public String getToken(AuthQuery authQuery) {

        String url = "http://localhost:9060/auth/token";
        ResponseEntity<String> exchange = restTemplateOne.exchange(url, HttpMethod.GET, null, String.class);
        HttpHeaders headers = exchange.getHeaders();
        String token = headers.get("Authorization").get(0);
        return token;
    }

    @Override
    public String getToken(AuthQuery authQuery, HttpServletRequest request, HttpServletResponse response) {

        String url = "http://localhost:9060/auth/token";

        String token1 = restTemplateOne.getForObject(url, String.class);

        ResponseEntity<String> exchange = restTemplateOne.exchange(url, HttpMethod.GET, null, String.class);
        HttpHeaders headers = exchange.getHeaders();
        String token2 = headers.get("Authorization").get(0);

        HttpHeaders httpHeaders = restTemplateOne.headForHeaders(url);
        String authorization = httpHeaders.get("Authorization").get(0);

        System.out.println("Token From Return : " + token1);
        System.out.println("Token From Header : " + token2);
        System.out.println("Token From Header : " + authorization);

        return token2;
    }
}