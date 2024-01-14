package com.digithn.library.config.handler;

import com.digithn.library.common.ErrorEnum;
import com.digithn.library.common.LibraryException;
import com.digithn.library.config.annotation.UserToken;
import com.digithn.library.dao.UserMapper;
import com.digithn.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@Component
public class UserTokenHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserMapper userMapper;


    public UserTokenHandlerMethodArgumentResolver() {
    }

    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(UserToken.class)) {
            return true;
        }
        return false;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.getParameterAnnotation(UserToken.class) != null) {
            String token = webRequest.getHeader("token");
            if (token == null || token.isEmpty()) {
                LibraryException.fail(ErrorEnum.NoLoginErr);
            }

            User user = userMapper.selectByToken(token);
            if (user == null) {
                LibraryException.fail(ErrorEnum.NoLoginErr);
            }
            if (user.getStatus().intValue() == 1) {
                LibraryException.fail(ErrorEnum.UserLimitErr);
            }
            return user;
        }
        return null;
    }
}
