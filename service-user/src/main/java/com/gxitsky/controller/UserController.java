package com.gxitsky.controller;

import com.alibaba.fastjson.JSON;
import com.gxitsky.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @name: ApiController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 11:51
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/getUser")
    public User getUser(Integer age, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        /*Enumeration<String> headerNames1 = request.getHeaderNames();
        System.out.println(JSON.toJSONString(headerNames1));

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            System.out.println("headerName:" + headerName + "; headerValue:" + headerValue);
        }*/


        User user = new User().setId(1001).setAge(age).setRealName("张三").setPort(serverPort);

        /*String userStr = JSON.toJSONString(user);
        Cookie cookie = new Cookie("userCookie", URLEncoder.encode(userStr, "utf-8"));
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        response.setHeader("userHeader", userStr);*/
        logger.info("user:{}", JSON.toJSONString(user));
        return user;
    }

}