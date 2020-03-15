package com.demo.shiro;

import com.demo.shiro.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.lang.model.type.ArrayType;
import java.util.*;

/**
 * 模拟数据库数据
 */
public class SystemUtils {


    /**
     * 模拟数据库中两条数据
     *
     * @return
     */
    public static List<User> users() {


        List<User> users = new ArrayList<>();

        // 添加数据
        users.add(new User(
                1L,
                "admin",
                "123456",
                new HashSet<>(Collections.singleton("admin")),
                new HashSet<>(Arrays.asList("user:add", "user:delete"))));

        users.add(new User(
                2L,
                "register",
                "123456",
                new HashSet<>(Collections.singleton("register")),
                new HashSet<>(Arrays.asList("user:view"))));

        return users;
    }

    /**
     * 获取用户
     * @param username
     * @return
     */
    public static User getUser(String username){

        List<User> users = SystemUtils.users();

        return users.stream().filter(user ->

            StringUtils.equalsAnyIgnoreCase(username,user.getUserName())).findFirst().orElse(null);
    }
}
