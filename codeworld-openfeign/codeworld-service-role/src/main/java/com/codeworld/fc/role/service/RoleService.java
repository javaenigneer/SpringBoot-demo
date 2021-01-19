package com.codeworld.fc.role.service;


import com.codeworld.fc.role.domian.ApiResult;
import com.codeworld.fc.role.entity.Role;

public interface RoleService {
    ApiResult<Role> getRoleByUserId(Integer userId);
}
