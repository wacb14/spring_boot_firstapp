package com.wacb14.spring.firstapp.spring_boot_firstapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
