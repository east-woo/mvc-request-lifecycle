package com.wavus.edu.mvcrequestlifecycle.argumentResolver;
import com.wavus.edu.mvcrequestlifecycle.dto.MyCustomDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoggingArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(LoggingArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("✅ supportsParameter 호출됨: " + parameter.getParameterType());
        return parameter.getParameterType().equals(MyCustomDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String paramValue = webRequest.getParameter("myParam");
        logger.info("🔹 [ArgumentResolver] 매개변수 값: {}", paramValue);
        return new MyCustomDto(paramValue);
    }
}