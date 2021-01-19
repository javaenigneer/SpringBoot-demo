package com.codeworld.fc.user.controller;

import com.codeworld.fc.user.domain.ApiResult;
import com.codeworld.fc.user.entity.User;
import com.codeworld.fc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName UserController
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    /**
     * 根据Id获取用户
     * @param id
     * @return
     */
    @GetMapping("get-user-id")
    public ApiResult<User> getUserById(@RequestParam("id") Integer id){
        return this.userService.getUserById(id);
    }
}
