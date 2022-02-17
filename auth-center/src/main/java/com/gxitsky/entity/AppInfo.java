package com.gxitsky.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @name: AppInfo
 * @desc: 应用信息
 * @author: gxing
 * @date: 2019-05-27 14:25
 **/
@Data
@Accessors(chain = true)
public class AppInfo {

    private Integer id;
    private String appId;
    private String secret;
    private String appName;
    private String appDesc;

    public AppInfo() {
    }

    public AppInfo(Integer id, String appId, String secret, String appName, String appDesc) {
        this.id = id;
        this.appId = appId;
        this.secret = secret;
        this.appName = appName;
        this.appDesc = appDesc;
    }
}