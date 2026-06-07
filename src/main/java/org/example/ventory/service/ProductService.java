package org.example.ventory.service;

import org.example.ventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = List.of(
        new Product(1, "Baby Joy"),
        new Product(2, "Laptop"),
        new Product(3, "Keyboard")
    );

    public Optional<Product> findById(int id) {
        return products.stream()
            .filter(product -> product.getId() == id)
            .findFirst();
    }

    public Product create(Product product) {
        return product;
    }
}
