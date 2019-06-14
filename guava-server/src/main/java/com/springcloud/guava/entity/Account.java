package com.springcloud.guava.entity;

/**
 * @name: User
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-06 15:02
 **/
public class Account {

    private String id;
    private String username;
    private String password;

    public Account() {
    }

    public Account(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public Account setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }
}