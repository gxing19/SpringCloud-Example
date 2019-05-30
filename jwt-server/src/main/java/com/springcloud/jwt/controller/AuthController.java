package com.springcloud.jwt.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.jwt.common.bean.ResultBean;
import com.springcloud.jwt.common.util.JavaJwtUtil;
import com.springcloud.jwt.entity.AppInfo;
import com.springcloud.jwt.entity.query.AuthQuery;
import com.springcloud.jwt.service.AppInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

        if (StringUtils.isBlank(authQuery.getAppId()) || StringUtils.isBlank(authQuery.getSecretKey())) {
            return new ResultBean().fialByNullParam().setMsg("appId and secretKey must not null");
        }

        AppInfo appInfo = appInfoService.queryAppInfo(authQuery);
        if (appInfo == null) {
            return new ResultBean().fialByNullParam().setMsg("auth fail");
        }
        String token = JavaJwtUtil.getTokenByRSA512(appInfo.getId().toString(), 60);

        //response.setHeader("Authorization", token);
        return new ResultBean().success().setDate(token);

    }

    /**
     * 验证 Token
     *
     * @param id      应用id
     * @param request
     * @return
     */
    @RequestMapping("/verify")
    public ResultBean getToken(String id, HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        boolean verify = JavaJwtUtil.verifyTokenByRSA512(token, id);
        if (!verify) {
            return new ResultBean().fial().setMsg("Token 验证失败");
        }
        return new ResultBean().success();
    }


}