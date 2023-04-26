package com.youkeda.application.ebusiness.control;

import com.youkeda.application.ebusiness.model.Result;
import com.youkeda.application.ebusiness.model.User;
import com.youkeda.application.ebusiness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Controller
public class UserControl {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/reg/api")
    @ResponseBody
    public Result<User> reg(@RequestBody User user, HttpServletRequest request, HttpServletResponse response,
                            HttpSession httpSession) {
        Result<User> result = userService.register(user);
        result.setSuccess(true);
        result.setData(user);
        return result;
    }

    @PostMapping(path = "/authenticate")
    @ResponseBody
    public Map login(@RequestParam String userName, @RequestParam String pwd,
                     HttpServletRequest request, HttpServletResponse response,Model model) {
        Map returnData = new HashMap();

        Result<User> result = userService.login(userName, pwd);
        if (result != null && result.isSuccess()) {
            request.getSession().setAttribute("userId", result.getData().getId());
            model.addAttribute("info", "登录成功！");
        } else {
            model.addAttribute("info", "登录失败！");
        }
        returnData.put("loginResult", result);
        return returnData;
    }
}
