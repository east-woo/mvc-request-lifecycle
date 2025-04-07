package com.wavus.edu.mvcrequestlifecycle.argumentResolver;

import com.wavus.edu.mvcrequestlifecycle.dto.CurrentUser;
import com.wavus.edu.mvcrequestlifecycle.dto.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null &&
               parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String authHeader = webRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            return parseToken(token);
        }
        return null;
    }

    private User parseToken(String token) {
        // 실제 서비스에서는 JWT 라이브러리로 토큰 파싱 + 검증
        if ("dummy-token".equals(token)) {
            return new User("user123", "John Doe");
        }
        return null;
    }
}