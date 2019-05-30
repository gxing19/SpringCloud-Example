package com.springcloud.service.consumer1.entity.query;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @name: AuthQuery
 * @desc: 认证实体
 * @author: gxing
 * @date: 2019-05-27 14:25
 **/
@Component
@ConfigurationProperties(prefix = "common.property.app")
public class AuthQuery {

    private String appId;
    private String secretKey;
    private String token;

    public AuthQuery() {
    }

    public AuthQuery(String appId, String secretKey) {
        this.appId = appId;
        this.secretKey = secretKey;
    }

    public String getAppId() {
        return appId;
    }

    public AuthQuery setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public AuthQuery setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getToken() {
        return token;
    }

    public AuthQuery setToken(String token) {
        this.token = token;
        return this;
    }
}