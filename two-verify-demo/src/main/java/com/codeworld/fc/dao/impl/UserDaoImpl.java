package com.codeworld.fc.dao.impl;

import com.codeworld.fc.dao.UserDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName UserDaoImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/10
 * Version 1.0
**/
@Component
public class UserDaoImpl implements UserDao {

    private final static Map<String, String> keyMap = new HashMap<>();

    @Override
    public String getSecretKey(String userName) {
        return keyMap.get(userName);
    }

    @Override
    public void saveUserCredentials(String userName, String secretKey) {
        keyMap.put(userName, secretKey);
    }
}
