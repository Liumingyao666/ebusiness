package com.youkeda.application.ebusiness.service;

import com.youkeda.application.ebusiness.model.Result;
import com.youkeda.application.ebusiness.model.User;

/**
 * @author 刘铭垚
 * @version 1.0
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    Result<User> register(User user);

    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    Result<User> login(String userName, String pwd);

}
