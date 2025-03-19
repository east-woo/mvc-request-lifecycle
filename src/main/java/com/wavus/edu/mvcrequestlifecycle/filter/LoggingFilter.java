package com.wavus.edu.mvcrequestlifecycle.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("🔹 [Filter] 요청 URL: {}", req.getRequestURI());
        chain.doFilter(request, response);
        logger.info("🔹 [Filter] 응답 처리 완료");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}