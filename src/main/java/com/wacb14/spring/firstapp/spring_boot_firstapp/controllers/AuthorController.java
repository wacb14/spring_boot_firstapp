package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Author;
import com.wacb14.spring.firstapp.spring_boot_firstapp.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> ListAuthors() {
        return new ResponseEntity<>(authorService.ListAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> GetById(@PathVariable Integer id) {
        Optional<Author> book = authorService.FindById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Author> Save(@RequestBody Author author) {
        Author saved = authorService.Save(author);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
