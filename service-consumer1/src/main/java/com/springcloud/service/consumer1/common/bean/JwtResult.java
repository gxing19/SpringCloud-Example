package com.springcloud.service.consumer1.common.bean;

/**
 * @name: JwtResult
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 11:37
 **/
public class JwtResult {

    private Boolean state;
    private String sub;
    private String msg;
    private Integer respCode;

    public JwtResult() {
    }

    public JwtResult(Boolean state, String sub, String msg, Integer respCode) {
        this.state = state;
        this.sub = sub;
        this.msg = msg;
        this.respCode = respCode;
    }

    public Boolean getState() {
        return state;
    }

    public JwtResult setState(Boolean state) {
        this.state = state;
        return this;
    }

    public String getSub() {
        return sub;
    }

    public JwtResult setSub(String sub) {
        this.sub = sub;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JwtResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public JwtResult setRespCode(Integer respCode) {
        this.respCode = respCode;
        return this;
    }
}