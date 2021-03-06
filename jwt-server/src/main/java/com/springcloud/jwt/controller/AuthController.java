package com.springcloud.jwt.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.commons.bean.JwtToken;
import com.springcloud.commons.bean.ResultBean;
import com.springcloud.commons.util.JavaJwtUtil;
import com.springcloud.jwt.entity.AppInfo;
import com.springcloud.jwt.entity.query.AuthQuery;
import com.springcloud.jwt.service.AppInfoService;
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
     * @param authQuery 认证参数
     * @param response  响应
     * @return ResultBean
     */
    @RequestMapping("/token")
    public ResultBean getToken(AuthQuery authQuery, HttpServletRequest request, HttpServletResponse response) {
        logger.info("authQuery:{}", JSON.toJSONString(authQuery));
        logger.info("JwtId:{},Authorization:{}",request.getHeader("JwtId"),request.getHeader("Authorization"));

        if (StringUtils.isBlank(authQuery.getAppId()) || StringUtils.isBlank(authQuery.getSecretKey())) {
            return new ResultBean().fialByNullParam().setMsg("appId and secretKey must not null");
        }

        //根据appId 和 secretKey 到数据库查询
        AppInfo appInfo = appInfoService.queryAppInfo(authQuery);
        if (appInfo == null) {
            return new ResultBean().fialByNullParam().setMsg("auth fail");
        }

        String jwtId =Long.toString(System.currentTimeMillis());
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
            return new ResultBean().fial().setMsg("Token 验证失败");
        }
        return new ResultBean().success();
    }
}