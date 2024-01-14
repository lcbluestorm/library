package com.digithn.library.dao;

import com.digithn.library.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectByNickname(@Param("nickname") String nickname);

    User selectByToken(@Param("token") String token);

}
