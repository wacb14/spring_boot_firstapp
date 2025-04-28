package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class Operations {
    @GetMapping("/divide")
    public String divide(@RequestParam String num, @RequestParam String den) {
        try {
            int n = Integer.parseInt(num);
            int d = Integer.parseInt(den);
            int result = n / d;
            return "Result: " + result;
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/getName")
    public String getName() {
        String name = null;
        return String.valueOf(name.length());
    }

}
