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

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PutMapping("/{id}")
    public ResponseEntity<Author> Update(@PathVariable Integer id, @RequestBody Author author) {
        Optional<Author> authorEntity = authorService.FindById(id);
        if (authorEntity.isPresent()) {
            Author authorUpdated = authorEntity.get();
            authorUpdated.setName(author.getName());
            authorUpdated.setLastName(author.getLastName());
            authorUpdated.setPhone(author.getPhone());
            return new ResponseEntity<>(authorService.Save(authorUpdated), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        try {
            authorService.Delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
