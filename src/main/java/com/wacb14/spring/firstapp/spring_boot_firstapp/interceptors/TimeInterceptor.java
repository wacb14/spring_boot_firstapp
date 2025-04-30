package com.wacb14.spring.firstapp.spring_boot_firstapp.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {
    private static final String START_TIME = "start";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute(START_TIME);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution time: " + endTime + " ms for URL: " + request.getRequestURI());
    }

}
