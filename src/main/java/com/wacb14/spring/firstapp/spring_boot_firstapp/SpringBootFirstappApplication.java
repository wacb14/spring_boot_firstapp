package com.wacb14.spring.firstapp.spring_boot_firstapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wacb14.spring.firstapp.spring_boot_firstapp.entities.Person;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.RepoPerson;

@SpringBootApplication
public class SpringBootFirstappApplication implements CommandLineRunner {

	@Autowired
	private RepoPerson repoPeople;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> people = (List<Person>) repoPeople.findAll();
		people.stream().forEach(person -> System.out.println(person));
	}

}
