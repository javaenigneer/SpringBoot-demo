package com.codeworld.fc.role.controller;

import com.codeworld.fc.role.domian.ApiResult;
import com.codeworld.fc.role.entity.Role;
import com.codeworld.fc.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName RoleController
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-role")
public class RoleController {

    @Autowired(required = false)
    private RoleService roleService;

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    @GetMapping("get-role-user-id")
    public ApiResult<Role> getRoleByUserId(@RequestParam("userId") Integer userId){
        return this.roleService.getRoleByUserId(userId);
    }
}
