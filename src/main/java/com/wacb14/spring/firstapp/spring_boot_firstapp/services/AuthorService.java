package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Author;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.AuthorRepo;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public List<Author> ListAuthors() {
        return authorRepo.findAll();
    }

    public Optional<Author> FindById(Integer id) {
        return authorRepo.findById(id);
    }

    public Author Save(Author author) {
        return (Author) authorRepo.save(author);
    }

    public void Delete(Integer id) {
        authorRepo.deleteById(id);
    }
}
