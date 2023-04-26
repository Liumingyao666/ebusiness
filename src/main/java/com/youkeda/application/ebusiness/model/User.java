package com.youkeda.application.ebusiness.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;

import javax.validation.constraints.NotNull;

/**
 * @author 刘铭垚
 * @version 1.0
 * 用户模型
 */
public class User extends BaseID<Long>{

    //用户名
    private String userName;

    //密码
    @JsonSerialize(using = NullSerializer.class)
    @NotNull
    private String pwd;

    //手机号
    private String mobile;

    //邮箱
    private String email;

    //姓名
    private String name;

    //头像
    private String avatarUrl;

    //性别
    private Gender gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
