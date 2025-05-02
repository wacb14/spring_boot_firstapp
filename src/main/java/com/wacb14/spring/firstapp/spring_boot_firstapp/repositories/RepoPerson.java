package com.wacb14.spring.firstapp.spring_boot_firstapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wacb14.spring.firstapp.spring_boot_firstapp.entities.Person;

public interface RepoPerson extends CrudRepository<Person, Long> {

}
