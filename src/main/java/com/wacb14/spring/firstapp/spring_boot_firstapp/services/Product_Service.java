package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.util.List;
import java.util.stream.Collectors;

import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.Repo_Product;

public class Product_Service {
    private Repo_Product products = new Repo_Product();

    public List<Product> getAll() {
        return products.getAll().stream()
                .map(p -> {
                    p.setPrice(p.getPrice() * 1.50);
                    return p;
                })
                .collect(Collectors.toList());
    }

    public Product getById(long idProduct) {
        return products.getById(idProduct);
    }
}
