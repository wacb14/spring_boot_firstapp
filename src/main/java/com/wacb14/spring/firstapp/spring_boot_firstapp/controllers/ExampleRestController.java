package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class ExampleRestController {
    // Both ways to declare the methods are the same
    @GetMapping("/getInfo")
    public Map<String, Object> getInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Bob");
        response.put("lastName", "Sponge");
        return response;
    }

    @RequestMapping(path = "/otherMethod", method = RequestMethod.GET)
    public Map<String, Object> otherMethod() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Bob");
        response.put("lastName", "Sponge");
        return response;
    }
}
