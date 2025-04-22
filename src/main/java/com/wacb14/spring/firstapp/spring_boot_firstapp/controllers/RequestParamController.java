package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.dto.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/parameters")
public class RequestParamController {
    @GetMapping("/hello")
    public Parameter hello(@RequestParam String title,
            @RequestParam(required = false, defaultValue = "XD") String description) {
        // If it doesn't receive the title (mandatory), the app will fail
        Parameter par = new Parameter();
        par.setTitle(title);
        par.setDescription(description);
        return par;
    }

}
