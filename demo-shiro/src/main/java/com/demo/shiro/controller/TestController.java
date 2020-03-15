package com.demo.shiro.controller;

import com.demo.shiro.entity.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * 测试Controller
 */
@Controller
@RequestMapping("test")
public class TestController {


    /**
     * 需要admin角色才能访问
     * @return
     */
    @GetMapping("admin")
    @RequiresRoles("admin")
    public ResponseEntity<Response> test1(){

        return ResponseEntity.ok(new Response().message("你是admin"));
    }


    /**
     * 拥有查看权限
     * @return
     */
    @GetMapping("view")
    @RequiresPermissions("admin:view")
    public ResponseEntity<Response> test2(){

        return ResponseEntity.ok(new Response().message("你有查看权限"));
    }
}
