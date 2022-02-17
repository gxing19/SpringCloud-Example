package com.gxitsky.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @name: UserInfo
 * @desc: 用户信息
 * @author: gxing
 * @date: 2019-06-19 10:23
 **/
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 8316990185935533197L;

    @Id
    private Long id;
    private String realName;
    private String nickName;
    private int age;
    private String address;

    public UserInfo() {
    }

    public UserInfo(Long id, String realName, String nickName, int age, String address) {
        this.id = id;
        this.realName = realName;
        this.nickName = nickName;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public UserInfo setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserInfo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserInfo setAddress(String address) {
        this.address = address;
        return this;
    }
}