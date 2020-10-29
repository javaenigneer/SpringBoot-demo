package com.codeworld.fc.controller;

import com.codeworld.fc.entity.User;
import com.codeworld.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName UserController
 * Description TODO
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
**/
@RestController
@RequestMapping("test-user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    // 根据Id获取用户
    @GetMapping("get-user-id/{id}")
    public User getUserById(@PathVariable("id") Integer id){

        return this.userService.getUserById(id);
    }
    // 根据id修改用户
    @PostMapping("update-user-id/{id}")
    public User updateUserById(@PathVariable("id") Integer id){
        return this.userService.updateUserById(id);
    }

    // 添加用户
    @PostMapping("add-user")
    public User addUser(){
        return this.userService.addUser();
    }

    // 根据id删除用户
    @PostMapping("delete-user/{id}")
    public User deleteUserById(@PathVariable("id") Long id){
        return this.userService.deleteUserById(id);
    }

}
