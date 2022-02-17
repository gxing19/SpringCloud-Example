package com.gxitsky.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @name: User
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-02 14:33
 **/
@ApiModel(value = "com.springcloud.service.consumer1.entity.User", description = "用户参数")
public class User {

    @ApiModelProperty(value = "用户编号", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户年龄", required = true)
    @Max(120)
    @Min(18)
    private Integer age;
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;
    @ApiModelProperty(value = "用户呢称", required = false)
    private String nickName;
    @ApiModelProperty(value = "用户地址", required = false)
    private String address;
    //    @ApiModelProperty(value = "用户生日", required = true)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @ApiModelProperty(value = "消息", required = true)
    private String msg;
    @ApiModelProperty(value = "文件", required = true)
    private MultipartFile file;

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

    public MultipartFile getFile() {
        return file;
    }

    public User setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}