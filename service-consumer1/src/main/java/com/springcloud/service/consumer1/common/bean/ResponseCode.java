package com.springcloud.service.consumer1.common.bean;

/**
 * @name: ResponseCode
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-27 11:43
 **/
public class ResponseCode {

    /*成功/正确 编码*/
    public static final int SUCCESS_CODE = 200;

    /*失败/错误 编码*/
    public static final int TOKEN_TIME_OUT = 401;
    public static final int NO_AUTO = 402;
    public static final int SIGN_ERROR = 402;
    public static final int PARAM_IS_NULL = 403;
    public static final int PARAM_IS_ERROR = 404;
}