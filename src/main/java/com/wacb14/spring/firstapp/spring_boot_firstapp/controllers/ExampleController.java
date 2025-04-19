package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    @GetMapping("/server_test")
    public String info() {
        return "server_test";
    }

}
