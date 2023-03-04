package com.youkeda.application.ebusiness.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControl {

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }
}
