package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class FileContent {
    public String readFile(String filePath) {
        try {
            Path route = Paths.get(filePath);
            return Files.readString(route);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file " + e.getMessage(), e);
        }
    }
}
