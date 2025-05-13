package com.wacb14.spring.firstapp.spring_boot_firstapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
