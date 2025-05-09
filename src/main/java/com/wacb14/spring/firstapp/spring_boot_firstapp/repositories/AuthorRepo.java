package com.wacb14.spring.firstapp.spring_boot_firstapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{
    
}
