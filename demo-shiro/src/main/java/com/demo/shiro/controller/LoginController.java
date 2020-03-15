package com.demo.shiro.controller;

import com.demo.shiro.entity.Response;
import com.demo.shiro.exception.SystemException;
import com.demo.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登陆Controller
 */
@Controller
public class LoginController {

    @Autowired(required = false)
    private LoginService loginService;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<Response> login(@RequestParam("username") String username,
                                          @RequestParam("password") String password) throws SystemException {

        Response response = this.loginService.login(username, password);

        return ResponseEntity.ok(response);
    }
}
