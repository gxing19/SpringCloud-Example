package com.gxitsky.entity;

import lombok.Data;

/**
 * @name: AuthRequest
 * @desc: 认证请求
 * @author: gxing
 * @date: 2019-05-27 14:25
 **/
@Data
public class AuthRequest {
    private String appId;
    private String secret;
}