package com.demo.shiro.config;

import com.demo.shiro.SystemUtils;
import com.demo.shiro.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class ShiroRealm extends AuthorizingRealm {


    /**
     * 登陆模块
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 获取用户名
        String username = (String) authenticationToken.getPrincipal();

        // 获取密码
        String password = new String((char[]) authenticationToken.getCredentials());

        // 根据用户名获取用户
        User user = SystemUtils.getUser(username);

        if (user == null || !StringUtils.equals(password, user.getUserPassword())){

            throw new IncorrectCredentialsException("用户名或密码错误");
        }

        // 登陆成功
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
    }

    /**
     * 授权模块
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 设置角色，模拟数据库
        simpleAuthorizationInfo.setRoles(user.getRole());

        // 设置权限
        simpleAuthorizationInfo.setStringPermissions(user.getPermission());

        return simpleAuthorizationInfo;
    }
}
