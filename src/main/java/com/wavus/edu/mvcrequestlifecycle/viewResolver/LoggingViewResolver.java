package com.wavus.edu.mvcrequestlifecycle.viewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Component
public class LoggingViewResolver implements ViewResolver {
    private static final Logger logger = LoggerFactory.getLogger(LoggingViewResolver.class);
    private final InternalResourceViewResolver delegate = new InternalResourceViewResolver();

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        logger.info("🔹 [ViewResolver] 뷰 선택: {}", viewName);
        return delegate.resolveViewName(viewName, locale);
    }
}