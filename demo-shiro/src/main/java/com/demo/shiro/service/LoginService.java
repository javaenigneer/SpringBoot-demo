package com.demo.shiro.service;

import com.demo.shiro.entity.Response;
import com.demo.shiro.exception.SystemException;

public interface LoginService {

    // 登陆
    Response login(String username, String password) throws SystemException;
}
