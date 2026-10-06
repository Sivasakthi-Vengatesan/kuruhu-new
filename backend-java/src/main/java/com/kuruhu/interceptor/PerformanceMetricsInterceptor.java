package com.kuruhu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PerformanceMetricsInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(PerformanceMetricsInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Object start = request.getAttribute("startTime");
        if (start instanceof Long) {
            long duration = System.currentTimeMillis() - (Long) start;
            log.debug("Request URI: {} - Duration: {}ms", request.getRequestURI(), duration);
        }
    }
}
