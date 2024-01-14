package com.digithn.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {

    private Long id;

    private String nickname;

    private String password;

    private String token;

    private Byte status;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public Byte getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
