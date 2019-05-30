package com.springcloud.service.consumer1.common.bean;

import java.io.Serializable;

/**
 * @name: ResultBean
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 14:06
 **/
public class ResultBean implements Serializable {

    private static final long serialVersionUID = -1936178861383421225L;

    private static final String STATE_SUCCESS = "success";
    private static final String STATE_FAIL = "fail";
    private static final Integer CODE_SUCCESS = 200;
    private static final Integer CODE_FAIL = 400;

    private Integer code;
    private String state;
    private String msg;
    private Object date;

    public ResultBean() {
    }

    public ResultBean(String state, Integer code, String msg, Object date) {
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public ResultBean success() {
        this.state = STATE_SUCCESS;
        this.code = CODE_SUCCESS;
        return this;
    }

    public ResultBean fial() {
        this.state = STATE_FAIL;
        this.code = CODE_FAIL;
        return this;
    }

    public ResultBean fialByNullParam() {
        this.state = STATE_FAIL;
        this.code = ResponseCode.PARAM_IS_NULL;
        return this;
    }

    public ResultBean fialByErrorParam() {
        this.state = STATE_FAIL;
        this.code = ResponseCode.PARAM_IS_ERROR;
        return this;
    }

    public String getState() {
        return state;
    }

    public ResultBean setState(String state) {
        this.state = state;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResultBean setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getDate() {
        return date;
    }

    public ResultBean setDate(Object date) {
        this.date = date;
        return this;
    }
}