package com.codeworld.fc.user.service.impl;

import com.codeworld.fc.user.client.RoleClient;
import com.codeworld.fc.user.domain.ApiResult;
import com.codeworld.fc.user.domain.Role;
import com.codeworld.fc.user.entity.User;
import com.codeworld.fc.user.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName UserServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private RoleClient roleClient;


    @Override
    public ApiResult<User> getUserById(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            return new ApiResult<>(0, "参数错误", null);
        }
        // 从数据中查询用户，通过用户id，这里为了方便就不演示数据库操作
        if (id == 10000) {
            User user = new User();
            user.setId(10000);
            user.setName("code");
            // 实现远程调用role服务
            ApiResult<Role> apiResult = this.roleClient.getRoleByUserId(id);
            if (apiResult.getCode() == 0) {
                return new ApiResult<>(0, apiResult.getMsg(), null);
            }
            if (ObjectUtils.isEmpty(apiResult.getData())) {
                // 若没有查询成功或者参数错误
                // 默认设置用户角色为test
                user.setRoleName("test");
            } else {
                user.setRoleName(apiResult.getData().getName());
            }
            return new ApiResult<>(1,"查询成功",user);
        }
        return new ApiResult<>(0, "查询失败", null);
    }
}
