package com.codeworld.fc.role.service.impl;

import com.codeworld.fc.role.domian.ApiResult;
import com.codeworld.fc.role.entity.Role;
import com.codeworld.fc.role.service.RoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;


/**
 * ClassName RoleServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
**/
@Service
public class RoleServiceImpl implements RoleService {


    @Override
    public ApiResult<Role> getRoleByUserId(Integer userId) {
        if (ObjectUtils.isEmpty(userId)){
            return new ApiResult<>(0,"参数错误",null);
        }
        // 这里就不演示数据库查询，直接设定
        if (userId == 10000){
            Role role = new Role();
            role.setId(10000);
            role.setName("admin");
            return new ApiResult<>(1,"查询成功",role);
        }
        return new ApiResult<>(0,"无数据",null);
    }
}
