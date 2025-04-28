package com.wacb14.spring.firstapp.spring_boot_firstapp.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> arithmeticExceptionHandler(ArithmeticException e) {
        return new ResponseEntity<String>("Error: Division by zero is not allowed", HttpStatus.BAD_REQUEST);
    }
}
