package com.demo.shiro.entity;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;


    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户角色
     */
    private Set<String> role;

    /**
     * 用户权限
     */
    private Set<String> permission;

    /**
     * 构造器
     * @param userId
     * @param userName
     * @param userPassword
     * @param role
     * @param permission
     */
    public User(Long userId, String userName, String userPassword, Set<String> role, Set<String> permission) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
        this.permission = permission;
    }
}
