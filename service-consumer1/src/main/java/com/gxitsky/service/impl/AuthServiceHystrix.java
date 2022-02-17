package com.gxitsky.service.impl;

import com.alibaba.fastjson.JSON;
import com.gxitsky.bean.ResultBean;
import com.gxitsky.entity.query.AuthQuery;
import com.gxitsky.service.AuthService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @name: AuthServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-28 09:56
 **/
@Service
public class AuthServiceHystrix implements FallbackFactory<AuthService> {

    @Override
    public AuthService create(Throwable throwable) {
        return new AuthService() {
            @Override
            public ResultBean getToken(AuthQuery authQuery) {
                throwable.printStackTrace();
                return new ResultBean().fial();
            }
        };
    }

    /*@Autowired
    private RestTemplate restTemplateOne;

    @Override
    public JwtToken getToken(AuthQuery authQuery) {

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
    }*/
}