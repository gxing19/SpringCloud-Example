package com.springcloud.service.user.controller;

import com.springcloud.service.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public User getUser(Integer age){
        User user = new User()
                .setId(1001).setAge(age).setRealName("张三").setPort(serverPort);
        return user;
    }

}