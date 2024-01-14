package com.digithn.library.controller;


import com.digithn.library.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.digithn.library.controller.param.UserLoginParam;
import com.digithn.library.service.UserService;
import com.digithn.library.utils.Result;


@RestController
@Api(value = "v1", tags = "1. user相关接口")
@RequestMapping("/api/v1")
public class UserController {

    @Resource
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user/login")
    @ApiOperation(value = "登录接口", notes = "返回token")
    public Result<User> login(@RequestBody @Valid UserLoginParam userLoginParam) {

        Result<User> result = userService.userLogin(userLoginParam.getNickname(), userLoginParam.getPassword());
        logger.info("login api. result = {}", result);
        return result;
    }
}
