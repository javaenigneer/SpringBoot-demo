package com.codeworld.fc.user.client;

import com.codeworld.fc.user.client.impl.RoleClientFallback;
import com.codeworld.fc.user.domain.ApiResult;
import com.codeworld.fc.user.domain.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "codeworld-service-role",fallback = RoleClientFallback.class)
public interface RoleClient {

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    @GetMapping("/codeworld-role/get-role-user-id")
    ApiResult<Role> getRoleByUserId(@RequestParam("userId") Integer userId);
}
