package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class Operations {
    @GetMapping("/divide")
    public String divide() {
        int result = 20 / 0;
        return "Result: " + result;
    }

}
