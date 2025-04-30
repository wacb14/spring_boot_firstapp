package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    @GetMapping("/index")
    public Map<String, Object> index(HttpServletRequest request) {
        Map<String, Object> data = new HashMap();
        data.put("title", "Schedule control system");
        data.put("time", new Date());
        data.put("message", request.getAttribute("message"));
        return data;
    }

}
