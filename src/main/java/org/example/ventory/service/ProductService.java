package org.example.ventory.service;

import org.example.ventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public Optional<Product> findById(int id) {
        return products.stream()
            .filter(product -> product.getId() == id)
            .findFirst();
    }

    public List<Product> getAll() {
        return products;
    }

    public Product create(Product product) {
        products.add(product);
        return product;
    }
}
