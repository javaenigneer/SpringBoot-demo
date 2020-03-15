package com.demo.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制
 **/

@Controller
public class ViewController {


    @RequestMapping("login.html")
    public String showLogin(){

        return "login";
    }
}
