package com.wacb14.spring.firstapp.spring_boot_firstapp.repositories;

import java.util.Arrays;
import java.util.List;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;

public class Repo_Product_Imp implements Repo_Product {
    List<Product> data;

    public Repo_Product_Imp() {
        this.data = Arrays.asList(
                new Product(001L, "Mouse RGB", 34.5),
                new Product(002L, "Keyboard AMD", 124.5),
                new Product(003L, "Mouse Intel", 33),
                new Product(004L, "Monitor ASUS", 3379),
                new Product(005L, "Laptop HP", 2334.5),
                new Product(006L, "Mousepad Red Dragon", 14.7));
    }

    public List<Product> getAll() {
        return data;
    }

    public Product getById(Long idProduct) {
        return data.stream()
                .filter(p -> p.getId().equals(idProduct))
                .findFirst().orElseThrow();
    }
}
