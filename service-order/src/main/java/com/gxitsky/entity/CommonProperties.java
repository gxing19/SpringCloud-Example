package com.gxitsky.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @name: CommonProperties
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-06 10:33
 **/
@Configuration
@ConfigurationProperties(prefix = "common.properties")
@RefreshScope
public class CommonProperties {

    private String appId;
    private String secret;
    private String key;

    public String getAppId() {
        return appId;
    }

    public CommonProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public CommonProperties setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getKey() {
        return key;
    }

    public CommonProperties setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public String toString() {
        return "CommonProperties{" +
                "appId='" + appId + '\'' +
                ", secret='" + secret + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}