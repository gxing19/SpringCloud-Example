package com.springcloud.service.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @name: User
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:33
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -8741964769880352812L;
    private Integer id;
    private Integer age;
    private String realName;
    private String nickName;
    private String address;
    private Date birthday;
    private String msg;
    private Integer port;

    public User() {
    }

    public User(Integer id, Integer age, String realName, String nickName, String address, Date birthday) {
        this.id = id;
        this.age = age;
        this.realName = realName;
        this.nickName = nickName;
        this.address = address;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public User setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public User setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public User setPort(Integer port) {
        this.port = port;
        return this;
    }
}