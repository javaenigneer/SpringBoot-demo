package com.codeworld.fc.dao;

public interface UserDao {

    String getSecretKey(String userName);

    void saveUserCredentials(String userName, String secretKey);
}
