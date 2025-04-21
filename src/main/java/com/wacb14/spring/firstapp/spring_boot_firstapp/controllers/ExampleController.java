package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.dto.User;

@Controller
public class ExampleController {
    @GetMapping("/server_test")
    public String info(Model model) {
        model.addAttribute("Title", "Server's loading...");
        model.addAttribute("Content", "Server's online!");
        model.addAttribute("IP", "192.168.1.10");
        return "server_test";
    }

    @GetMapping("/user-profile")
    public String userProfile(Model model) {
        User user = new User();
        user.setUser("pepelucho");
        user.setPassword(null);
        model.addAttribute(user);
        return "user-profile";
    }

}
