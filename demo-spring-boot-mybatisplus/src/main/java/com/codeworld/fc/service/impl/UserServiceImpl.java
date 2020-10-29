package com.codeworld.fc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeworld.fc.entity.User;
import com.codeworld.fc.mapper.UserMapper;
import com.codeworld.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName UserServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {

        return this.userMapper.selectById(id);

    }

    /**
     * 根据id修改用户
     *
     * @param id
     * @return
     */
    @Override
    public User updateUserById(Integer id) {
        // 我们这里就模拟数据啦
        User user = new User();
        user.setId(id);
        user.setName("zs");
        user.setPassword("000000");
        this.userMapper.updateById(user);
        return user;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @Override
    public User addUser() {
        // 这里我们就创建一个模拟数据
        User user = new User();
        user.setName("add");
        user.setPassword("11111");
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Override
    public User deleteUserById(Long id) {
        // 先查询,这里没有做任何逻辑判断
        User user = this.userMapper.selectById(id);
        this.userMapper.deleteById(id);
        return user;
    }
}
