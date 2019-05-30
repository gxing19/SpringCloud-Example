package com.springcloud.service.consumer1.common.config;

import com.alibaba.fastjson.JSON;
import com.springcloud.service.consumer1.common.bean.ResultBean;
import com.springcloud.service.consumer1.entity.query.AuthQuery;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: InitTokenConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-29 15:25
 **/
@Component
public class InitTokenConfig implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplateOne;
    @Autowired
    private AuthQuery authQuery;
    @Autowired
    private Environment environment;


    @Override
    public void run(String... args) throws Exception {

        String url = "http://localhost:9060/auth/token";

        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("appId", this.authQuery.getAppId());
        paramMap.add("secretKey", this.authQuery.getSecretKey());
        ResultBean resultBean = restTemplateOne.postForObject(url, paramMap, ResultBean.class);
        assert resultBean != null;
        String token = (String) resultBean.getDate();

//        String paramMapStr = JSON.toJSONString(this.authQuery);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//
//        HttpEntity<String> httpEntity = new HttpEntity<>(paramMapStr, headers);
//        ResponseEntity<ResultBean> responseEntity = restTemplateOne.postForEntity(url, httpEntity, ResultBean.class);
//        String token = (String) responseEntity.getBody().getDate();

        //设置到系统环境
        System.setProperty("token", token);
        authQuery.setToken(token);

    }
}