package com.gxitsky.bean;

import java.io.Serializable;

/**
 * @name: JwtToken
 * @desc: JWT 实体
 * @author: gxing
 * @date: 2019-05-30 14:00
 **/
public class JwtToken implements Serializable {
    private static final long serialVersionUID = 7780238154438192887L;

    private String jwtId;
    private String token;

    public JwtToken() {
    }

    public JwtToken(String jwtId, String token) {
        this.jwtId = jwtId;
        this.token = token;
    }

    public String getJwtId() {
        return jwtId;
    }

    public JwtToken setJwtId(String jwtId) {
        this.jwtId = jwtId;
        return this;
    }

    public String getToken() {
        return token;
    }

    public JwtToken setToken(String token) {
        this.token = token;
        return this;
    }
}