package com.codeworld.fc.user.client.impl;

import com.codeworld.fc.user.client.RoleClient;
import com.codeworld.fc.user.domain.ApiResult;
import com.codeworld.fc.user.domain.Role;
import org.springframework.stereotype.Component;

/**
 * ClassName RoleClientFallback
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
**/
@Component
public class RoleClientFallback implements RoleClient {
    /**
     * 根据用户id获取角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public ApiResult<Role> getRoleByUserId(Integer userId) {
        return new ApiResult<>(0,"请求超时",null);
    }
}
