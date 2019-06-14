package com.springcloud.service.consumer1.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.service.consumer1.entity.User;
import com.springcloud.service.consumer1.entity.query.AuthQuery;
import com.springcloud.service.consumer1.service.UserService;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

/**
 * @name: UserController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:45
 **/
@RestController
@RequestMapping("/user")
@Api(value = "com.springcloud.service.consumer1.controller.UserController", description = "用户相关操作")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired(required = false)
    private UserService userService;
    @Autowired
    private AuthQuery authQuery;
    @Autowired
    private Environment environment;

    @ApiOperation(value = "获取用户", notes = "路径传参, 年龄参数")
    @GetMapping("/getUser/{age}")
    public String getUser(@ApiParam(value = "年龄参数", required = true) @PathVariable Integer age, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info("age", age);

        /*String reqToken = request.getHeader("Token");
        System.out.println("reqToken：" + reqToken);
        String reqHeader = request.getHeader("Header");
        System.out.println("reqHeader：" + reqHeader);*/

        HashMap<String, Integer> paramMap = new HashMap<>();
        paramMap.put("age", age);
        String user = userService.getUser(paramMap);

        /*Cookie cookie = new Cookie("user",URLEncoder.encode(user,"utf-8"));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        response.setHeader("respHeader", user);*/

        return user;
    }

    @ApiOperation(value = "根据ID获取用户")
    @GetMapping("/getUserById")
    public String getUserById(@ApiParam(value = "用户ID", required = true) User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        logger.info("user:{}", JSON.toJSONString(user));

        user.setAddress("深圳罗湖").setAge(23).setRealName("天天").setNickName("TT").setBirthday(new Date());

        return JSON.toJSONString(user);
    }

}
