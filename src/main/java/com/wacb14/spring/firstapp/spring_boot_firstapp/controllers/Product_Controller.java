package com.wacb14.spring.firstapp.spring_boot_firstapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;
import com.wacb14.spring.firstapp.spring_boot_firstapp.services.Product_Service_Imp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class Product_Controller {
    Product_Service_Imp products = new Product_Service_Imp();

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return products.getAll();
    }

    @GetMapping("/getById")
    public Product getById(@RequestParam long id) {
        return products.getById(id);
    }

}
