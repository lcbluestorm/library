package com.digithn.library.service.impl;

import com.digithn.library.common.ErrorEnum;
import com.digithn.library.dao.UserMapper;
import com.digithn.library.entity.User;
import com.digithn.library.service.UserService;
import com.digithn.library.utils.Result;
import com.digithn.library.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> userLogin(String nickname, String password) {
        logger.info("userLogin. nickname: {}, password: {}", nickname, password);
        User user = userMapper.selectByNickname(nickname);
        logger.info("userLogin. user: {}", user);
        if(user == null || !user.getPassword().equals(password)) {
            return ResultGenerator.getErrorResult(ErrorEnum.LoginFailedErr);
        }
        user.setPassword("");
        return ResultGenerator.getSuccessResult(user);
    }

    @Override
    public User getUserByToken(String token) {
        User user = userMapper.selectByToken(token);
        logger.info("getUserByToken. token: {}, user: {}", token, user);
        return user;
    }
}
