package com.springcloud.shardingjdbc.controller;

import com.springcloud.shardingjdbc.entity.UserInfo;
import com.springcloud.shardingjdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @name: UserInfoController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-19 10:25
 **/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 读取数据
     * @return
     */
    @RequestMapping("/getAll")
    public List<UserInfo> getAll() {
        List<UserInfo> userInfoList = userInfoService.getAll();
        return userInfoList;
    }

    /**
     * 读取数据,Hint 强制路由到主库
     * @return
     */
    @RequestMapping("/getById")
    public UserInfo getByIdFromMaster(Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return userInfo;
    }

    @RequestMapping("/getByIdFromRepo")
    public UserInfo getByIdFromRepo(Long id) {
        UserInfo userInfo = userInfoService.getByIdFromRepo(id);
        return userInfo;
    }

    /**
     * 写入数据
     * @param id
     * @return
     */
    @RequestMapping("/add")
    public int addUserInfo(Long id) {
        UserInfo userInfo = new UserInfo(id, "李小小", "Li xiao xiao", 19, "南山");
        int rows = userInfoService.addUserInfo(userInfo);
        return rows;
    }
}