package com.codeworld.fc.user.controller;

import com.codeworld.fc.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName UserController
 * Description TODO
 * Author Lenovo
 * Date 2021/2/20
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-user")
public class UserController {

    @GetMapping("get-user")
    public User getUser(){
       User user = new User();
       user.setId(1);
       user.setUsername("zs");
       return user;
    }
}
