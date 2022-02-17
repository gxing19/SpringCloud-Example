package com.gxitsky.entity.query;

/**
 * @name: AuthQuery
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:25
 **/
public class AuthQuery {

    private String appId;
    private String secretKey;

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
}