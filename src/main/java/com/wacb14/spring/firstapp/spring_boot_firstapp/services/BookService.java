package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Book;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.BookRepo;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> ListBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> FindById(Integer id) {
        return bookRepo.findById(id);
    }

    public Book Save(Book author) {
        return (Book) bookRepo.save(author);
    }

    public void Delete(Integer id) {
        bookRepo.deleteById(id);
    }
}
