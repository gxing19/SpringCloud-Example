package com.springcloud.service.consumer1.controller;

import com.springcloud.service.consumer1.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getUser")
    public String getUser(){
        return userInterface.getUser();
    }
}
