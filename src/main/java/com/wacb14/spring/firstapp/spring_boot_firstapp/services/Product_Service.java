package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.util.List;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;

public interface Product_Service {
    public List<Product> getAll();
    public Product getById(long idProduct);
}
