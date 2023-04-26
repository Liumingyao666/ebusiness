package com.youkeda.application.ebusiness.control;

import com.youkeda.application.ebusiness.model.Gender;
import com.youkeda.application.ebusiness.model.Result;
import com.youkeda.application.ebusiness.model.User;
import com.youkeda.application.ebusiness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘铭垚
 * @version 1.0
 * 用户服务测试
 */
@Controller
public class UserTestControl {

    @Autowired
    private UserService userService;

    @GetMapping("/test/user")
    @ResponseBody
    public Map testUser() {
        Map result = new HashMap();

        User user = new User();
        user.setUserName("冰冰");
        user.setPwd("123456");
        user.setMobile("174375893");
        user.setEmail("432423@qq.com");
        user.setName("王冰冰");
        user.setAvatarUrl("www.baidu.com");
        user.setGender(Gender.female);


        Result result1 = userService.register(user);
        result.put("注册测试", result1);

        Result result2 = userService.login("冰冰", "123456");
        result.put("登陆测试", result2);


        return result;
    }
}
