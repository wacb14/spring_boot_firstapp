package com.wacb14.spring.firstapp.spring_boot_firstapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.wacb14.spring.firstapp.spring_boot_firstapp.interceptors.ScheduleInterceptor;
import com.wacb14.spring.firstapp.spring_boot_firstapp.interceptors.TimeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ScheduleInterceptor scheduleInterceptor;

    public WebConfig(ScheduleInterceptor scheduleInterceptor) {
        this.scheduleInterceptor = scheduleInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(scheduleInterceptor);
        registry.addInterceptor(new TimeInterceptor());
    }
}
