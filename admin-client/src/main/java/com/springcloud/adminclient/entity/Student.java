package com.springcloud.adminclient.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @name: Student
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-05 16:06
 **/
public class Student {

    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Student() {
    }

    public Student(Integer id, Date birthday) {
        this.id = id;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Student setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}