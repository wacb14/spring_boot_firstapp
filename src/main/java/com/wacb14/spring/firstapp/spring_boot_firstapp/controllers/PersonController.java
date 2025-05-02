package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wacb14.spring.firstapp.spring_boot_firstapp.entities.Person;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.PersonRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonRepo peopleRepo;

    @GetMapping("/getPeople")
    public List<Person> getPeople() {
        return (List<Person>) peopleRepo.findAll();
    }

}
