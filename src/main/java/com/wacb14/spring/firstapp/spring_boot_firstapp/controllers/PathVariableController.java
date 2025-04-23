package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.dto.Parameter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/variable")
public class PathVariableController {
    // These values are brought from the file application.properties
    @Value("${config.name}")
    private String name;
    @Value("${config.age}")
    private int age;
    @Value("${config.colors}")
    String[] colors;

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> values = new HashMap<>();
        values.put("name", name);
        values.put("age", age);
        values.put("colors", colors);
        return values;
    }

    @GetMapping("/page/{message}")
    public Parameter page(@PathVariable String message) {
        Parameter param = new Parameter();
        param.setTitle(message);
        return param;
    }

    @PostMapping("/request")
    public Parameter request(@RequestBody Parameter parameter) {

        return parameter;
    }

}
