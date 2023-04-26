package com.youkeda.application.ebusiness.service.impl;

import com.youkeda.application.ebusiness.dao.UserDAO;
import com.youkeda.application.ebusiness.dataobject.UserDO;
import com.youkeda.application.ebusiness.model.Gender;
import com.youkeda.application.ebusiness.model.Result;
import com.youkeda.application.ebusiness.model.User;
import com.youkeda.application.ebusiness.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result<User> register(User user) {
        Result result = new Result();

        if (user == null) {
            return null;
        }

        //注册用户名不能为空
        if (StringUtils.isEmpty(user.getUserName())) {
            result.setCode("600");
            result.setMessage("用户名不能为空");
            return result;
        }

        //密码不能为空
        if (StringUtils.isEmpty(user.getPwd())) {
            result.setCode("601");
            result.setMessage("密码不能为空");
            return result;
        }

        UserDO userDO = (UserDO)redisTemplate.opsForValue().get(user.getUserName());

        if (userDO == null) {
            userDO = userDAO.findByUserName(user.getUserName());
        }

        //用户名不能重复
        if (userDO != null) {
            result.setCode("602");
            result.setMessage("用户名已存在");
            return result;
        }

        String saltPwd = user.getPwd() + "_ykd2050";
        String md5Pwd = DigestUtils.md5Hex(saltPwd).toUpperCase();

        UserDO userDO1 = new UserDO();
        userDO1.setUserName(user.getUserName());
        userDO1.setPassword(md5Pwd);
        userDO1.setMobile(user.getMobile());
        userDO1.setEmail(user.getEmail());
        userDO1.setAvatarUrl(user.getAvatarUrl());
        userDO1.setName(user.getName());
        userDO1.setGender(user.getGender().name());
        userDAO.add(userDO1);

        //设置执行成功
        result.setSuccess(true);
        //将UserDO转化成user对象
        User user1 = userDO1.toModel();
        result.setData(user1);

        //新用户注册成功后，存入缓存
        redisTemplate.opsForValue().set(user.getUserName(),userDO1);
        return result;
    }

    @Override
    public Result<User> login(String userName, String pwd) {
        Result result = new Result();

        //用户名和密码不能为空
        if (StringUtils.isEmpty(userName)) {
            result.setCode("600");
            result.setMessage("用户名不能为空");
            return result;
        }

        if (StringUtils.isEmpty(pwd)) {
            result.setCode("601");
            result.setMessage("密码不能为空");
            return result;
        }

        UserDO userDO = (UserDO) redisTemplate.opsForValue().get(userName);

        //判断缓存中找到的数据是否为空，为空去数据库中找
        if (userDO == null) {
            userDO = userDAO.findByUserName(userName);
        }

        //用户名不存在
        if (userDO == null) {
            result.setCode("602");
            result.setMessage("用户名不存在");
            return result;
        }

        //密码加自定义盐值，确保密码安全
        String saltPwd = pwd + "_ykd2050";
        //生成md5值，并转为大写字母
        String md5Pwd = DigestUtils.md5Hex(saltPwd).toUpperCase();

        if (!StringUtils.equals(md5Pwd, userDO.getPassword())) {
            result.setCode("603");
            result.setMessage("密码错误");
            return result;
        }

        result.setSuccess(true);
        User user = userDO.toModel();
        result.setData(user);

        return result;
    }
}
