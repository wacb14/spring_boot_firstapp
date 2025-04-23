package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.dto.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/variable")
public class PathVariableController {

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
