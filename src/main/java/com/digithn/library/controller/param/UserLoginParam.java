package com.digithn.library.controller.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class UserLoginParam {

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String nickname;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
