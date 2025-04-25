package com.wacb14.spring.firstapp.spring_boot_firstapp.repositories;

import java.util.List;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;

public interface Repo_Product {
    public List<Product> getAll();
    public Product getById(Long idProduct);
}
