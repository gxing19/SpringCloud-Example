package com.gxitsky.service;

import com.gxitsky.entity.UserInfo;

import java.util.List;

/**
 * @name: UserInfoService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-19 10:28
 **/
public interface UserInfoService {
    List<UserInfo> getAll();

    int addUserInfo(UserInfo userInfo);

    UserInfo getById(Long id);

    UserInfo getByIdFromRepo(Long id);
}