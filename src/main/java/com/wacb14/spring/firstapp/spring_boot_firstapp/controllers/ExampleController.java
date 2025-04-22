package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Employee;
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

    @GetMapping("/employees-list")
    public String employeesList() {
        return "employees-list";
    }

    @ModelAttribute("Employees")
    public List<Employee> EmployeesList() {
        return Arrays.asList(
                new Employee(1, "Pepe Gonzales", "Las Lomas 132", 45),
                new Employee(2, "Francesca Maldini", "Las Lomas 133", 65),
                new Employee(3, "Miguel Ignacio De las Casas", "Las Lomas 134", 50),
                new Employee(4, "Fernanda De las Casas", "Las Lomas 133", 23));
    }

}
