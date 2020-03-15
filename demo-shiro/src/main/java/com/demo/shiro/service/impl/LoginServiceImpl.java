package com.demo.shiro.service.impl;

import com.demo.shiro.SystemUtils;
import com.demo.shiro.entity.Response;
import com.demo.shiro.entity.User;
import com.demo.shiro.exception.SystemException;
import com.demo.shiro.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * 登陆Service
 */
@Service
public class LoginServiceImpl implements LoginService {


    /**
     * 登陆操作
     * @param username
     * @param password
     * @return
     */
    @Override
    public Response login(String username, String password) throws SystemException {

        Subject subject = SecurityUtils.getSubject();


        // 判断是否存在
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){

            throw new SystemException("请输入信息");
        }

        try {
            // 执行登陆
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

            subject.login(usernamePasswordToken);

            User user = (User) subject.getPrincipal();

            return new Response().message("认证成功").data(user);

        } catch (AuthenticationException e) {

            e.printStackTrace();

            throw new SystemException("认证失败");
        }

    }
}
