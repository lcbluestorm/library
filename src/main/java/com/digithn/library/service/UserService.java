package com.digithn.library.service;

import com.digithn.library.entity.User;
import com.digithn.library.utils.Result;

public interface UserService {

    Result<User> userLogin(String loginName, String passwordMD5);

    User getUserByToken(String token);

}
