package com.youkeda.application.ebusiness.dataobject;

import com.youkeda.application.ebusiness.model.Gender;
import com.youkeda.application.ebusiness.model.User;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 刘铭垚
 * @version 1.0
 */
public class UserDO implements Serializable {
    private long id;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

    private String userName;

    private String password;

    private String mobile;

    private String email;

    private String name;

    private String avatarUrl;

    private String gender;

    /**
     * DO转化为Model
     * @return
     */
    public User toModel(){
        User user = new User();
        user.setId(getId());
        user.setUserName(getUserName());
        user.setPwd(getPassword());
        user.setMobile(getMobile());
        user.setEmail(getEmail());
        user.setAvatarUrl(getAvatarUrl());
        user.setName(getName());
        user.setGender(Gender.valueOf(getGender()));
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
