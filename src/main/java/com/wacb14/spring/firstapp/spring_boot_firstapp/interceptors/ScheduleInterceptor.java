package com.wacb14.spring.firstapp.spring_boot_firstapp.interceptors;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ScheduleInterceptor implements HandlerInterceptor {
    @Value("${config.schedule.open}")
    private int open;
    @Value("${config.schedule.close}")
    private int close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        int time = calendar.get(Calendar.HOUR_OF_DAY);
        if (time >= open && time < close) {
            StringBuilder message = new StringBuilder("Welcome! ");
            message.append("We're open since " + open + "hrs ");
            message.append("until  " + close + "hrs ");
            message.append("Thank you for coming!");
            request.setAttribute("message", message);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

    }

}
