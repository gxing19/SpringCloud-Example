package com.springcloud.service.consumer1.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.service.consumer1.service.UserInterface;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @name: UserController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:45
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserInterface userInterface;

    @GetMapping("/getUser/{age}")
    public String getUser(@PathVariable Integer age, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        /*String reqToken = request.getHeader("Token");
        System.out.println("reqToken：" + reqToken);
        String reqHeader = request.getHeader("Header");
        System.out.println("reqHeader：" + reqHeader);*/

        HashMap<String, Integer> paramMap = new HashMap<>();
        paramMap.put("age", age);
        String user = userInterface.getUser(paramMap);

        /*Cookie cookie = new Cookie("user",URLEncoder.encode(user,"utf-8"));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        response.setHeader("respHeader", user);*/

        return user;
    }
}
