package com.springcloud.service.user.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.springcloud.service.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @name: ApiController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 11:51
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/getUser")
    public User getUser(Integer age, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String token = request.getHeader("Token");
        System.out.println(token);

        User user = new User().setId(1001).setAge(age).setRealName("张三").setPort(serverPort);

        String userStr = JSON.toJSONString(user);
        Cookie cookie = new Cookie("userCookie", URLEncoder.encode(userStr, "utf-8"));
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        response.setHeader("userHeader", userStr);

        return user;
    }

}