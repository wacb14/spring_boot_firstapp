package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Book;
import com.wacb14.spring.firstapp.spring_boot_firstapp.services.BookService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> ListBooks() {
        return new ResponseEntity<>(bookService.ListBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> GetById(@PathVariable Integer id) {
        Optional<Book> book = bookService.FindById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> Save(@RequestBody Book book) {
        Book saved = bookService.Save(book);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> Update(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> bookEntity = bookService.FindById(id);
        if (bookEntity.isPresent()) {
            Book bookUpdated = bookEntity.get();
            bookUpdated.setTitle(book.getTitle());
            bookUpdated.setEditorial(book.getEditorial());
            bookUpdated.setGenre(book.getGenre());
            bookUpdated.setPrice(book.getPrice());
            bookUpdated.setDateEdition(book.getDateEdition());
            bookUpdated.setAuthor(book.getAuthor());
            return new ResponseEntity<>(bookService.Save(bookUpdated), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        try {
            bookService.Delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
