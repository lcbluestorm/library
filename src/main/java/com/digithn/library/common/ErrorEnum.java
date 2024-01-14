package com.digithn.library.common;

public enum ErrorEnum {

    LoginFailedErr(-10000, "用户名或者密码错误"),
    NoLoginErr(-10001, "请先登录"),
    UserLimitErr(-10002, "用户已被禁用"),

    BookNotExistErr(-20000, "未找到当前书籍"),

    UnknownError(-90000, "未知错误");

    private int code;

    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
