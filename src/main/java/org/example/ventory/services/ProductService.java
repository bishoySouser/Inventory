package org.example.ventory.services;

import org.example.ventory.entities.Product;
import org.example.ventory.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product CreateNewProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getCheapProducts() {
        return productRepository.findByPriceLessThan(20.0);
    }
}
