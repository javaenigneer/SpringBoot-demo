package com.codeworld.fc.user.service;

import com.codeworld.fc.user.domain.ApiResult;
import com.codeworld.fc.user.entity.User;

public interface UserService {

    ApiResult<User> getUserById(Integer id);
}
