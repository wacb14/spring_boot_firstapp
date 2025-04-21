package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Employee;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.dto.User;

@RestController
@RequestMapping("/api")
public class ExampleRestController {
    // Both ways to declare the methods are valid
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

    @RequestMapping(path = "/employeeInfo", method = RequestMethod.GET)
    public Map<String, Object> employeeInfo() {
        Map<String, Object> response = new HashMap<>();
        Employee employee = new Employee(1, "Jules Verne", "Rutheford Lincoln Boulevard 123", 54);
        response.put("Employee", employee);
        return response;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User user() {
        User u1 = new User();
        u1.setUser("pepelucho123");
        u1.setPassword("1233456");
        return u1;
    }
}
