package com.springcloud.jwt.entity;

/**
 * @name: AuthQuery
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:25
 **/
public class AppInfo {

    private Integer id;
    private String appId;
    private String secretKey;
    private String appName;
    private String appDesc;

    public AppInfo() {
    }

    public AppInfo(Integer id, String appId, String secretKey, String appName, String appDesc) {
        this.id = id;
        this.appId = appId;
        this.secretKey = secretKey;
        this.appName = appName;
        this.appDesc = appDesc;
    }

    public Integer getId() {
        return id;
    }

    public AppInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public AppInfo setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public AppInfo setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public AppInfo setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public AppInfo setAppDesc(String appDesc) {
        this.appDesc = appDesc;
        return this;
    }
}