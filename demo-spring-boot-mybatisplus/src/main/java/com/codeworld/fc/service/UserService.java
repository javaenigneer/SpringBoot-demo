package com.codeworld.fc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeworld.fc.entity.User;

public interface UserService extends IService<User> {
    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 根据id修改用户
     * @param id
     * @return
     */
    User updateUserById(Integer id);

    /**
     * 添加用户
     * @return
     */
    User addUser();

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    User deleteUserById(Long id);
}
