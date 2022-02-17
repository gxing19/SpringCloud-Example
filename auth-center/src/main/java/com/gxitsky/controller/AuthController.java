package com.gxitsky.controller;

import com.alibaba.fastjson.JSON;
import com.gxitsky.bean.JwtToken;
import com.gxitsky.bean.ResultBean;
import com.gxitsky.entity.AppInfo;
import com.gxitsky.entity.AuthRequest;
import com.gxitsky.service.AppInfoService;
import com.gxitsky.util.JavaJwtUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name: tokenAuth
 * @desc: 认证API
 * @author: gxing
 * @date: 2019-05-27 14:02
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private AppInfoService appInfoService;

    /**
     * 签发 Token
     *
     * @param authRequest 认证参数
     * @param response  响应
     * @return ResultBean
     */
    @RequestMapping("/token")
    public ResultBean getToken(AuthRequest authRequest, HttpServletRequest request, HttpServletResponse response) {
        logger.info("authQuery:{}", JSON.toJSONString(authRequest));
        logger.info("JwtId:{},Authorization:{}", request.getHeader("JwtId"), request.getHeader("Authorization"));

        if (StringUtils.isBlank(authRequest.getAppId()) || StringUtils.isBlank(authRequest.getSecret())) {
            return new ResultBean().failByNullParam().setMsg("appId and secretKey must not null");
        }

        //根据appId 和 secret 到数据库查询
        AppInfo appInfo = appInfoService.queryAppInfo(authRequest);
        if (appInfo == null) {
            return new ResultBean().failByNullParam().setMsg("auth fail");
        }

        String jwtId = Long.toString(System.currentTimeMillis());
        //1440分钟=24小时
        String token = JavaJwtUtil.getTokenByRSA512(jwtId, 1440);

        JwtToken jwtToken = new JwtToken(jwtId, token);

        return new ResultBean().success().setDate(jwtToken);
    }

    /**
     * 验证 Token
     *
     * @param request
     * @return
     */
    @RequestMapping("/verify")
    public ResultBean verifyToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        String jwtId = request.getHeader("jwtId");
        boolean verify = JavaJwtUtil.verifyTokenByRSA512(token, jwtId);
        if (!verify) {
            return new ResultBean().fail().setMsg("Token 验证失败");
        }
        return new ResultBean().success();
    }
}