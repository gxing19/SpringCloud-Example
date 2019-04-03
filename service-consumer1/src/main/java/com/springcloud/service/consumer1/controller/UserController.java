package com.springcloud.service.consumer1.controller;

import com.springcloud.service.consumer1.service.UserInterface;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getUser(@PathVariable Integer age){
        HashMap<String,Integer> paramMap = new HashMap<>();
        paramMap.put("age",age);
        return userInterface.getUser(paramMap);
    }
}
