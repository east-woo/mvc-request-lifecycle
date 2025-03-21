package com.wavus.edu.mvcrequestlifecycle.config;

import com.wavus.edu.mvcrequestlifecycle.argumentResolver.LoggingArgumentResolver;
import com.wavus.edu.mvcrequestlifecycle.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;

    private final LoggingArgumentResolver loggingArgumentResolver;

    @Autowired
    public WebConfig(LoggingArgumentResolver loggingArgumentResolver, LoggingInterceptor loggingInterceptor,
                     ApplicationContext applicationContext) {
        this.loggingArgumentResolver = loggingArgumentResolver;
        this.loggingInterceptor = loggingInterceptor;

        // 빈 등록 확인
        System.out.println("🔎 LoggingArgumentResolver 존재 여부: " + applicationContext.containsBean("loggingArgumentResolver"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(0,loggingArgumentResolver);
    }
}