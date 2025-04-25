package com.wacb14.spring.firstapp.spring_boot_firstapp.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wacb14.spring.firstapp.spring_boot_firstapp.models.Product;
import com.wacb14.spring.firstapp.spring_boot_firstapp.repositories.Repo_Product;

@Component
public class Product_Service_Imp implements Product_Service{
    @Autowired
    private Repo_Product products;

    public List<Product> getAll() {
        return products.getAll().stream()
                .map(p -> {
                    double newPrice = p.getPrice() * 1.50;
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(newPrice);
                    return newProduct;
                })
                .collect(Collectors.toList());
    }

    public Product getById(long idProduct) {
        return products.getById(idProduct);
    }
}
