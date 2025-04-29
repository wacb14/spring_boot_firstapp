package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wacb14.spring.firstapp.spring_boot_firstapp.services.FileContent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class FileController {
    private final FileContent content;

    public FileController(FileContent content) {
        this.content = content;
    }

    @GetMapping("/show")
    public ResponseEntity<String> show(@RequestParam String filePath) {
        try {
            String file = content.readFile(filePath);
            return ResponseEntity.ok(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("There was an error reading the file " + e);
        }
    }

}
