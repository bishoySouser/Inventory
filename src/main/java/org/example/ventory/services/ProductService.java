package org.example.ventory.services;

import org.example.ventory.entities.Product;
import org.example.ventory.exceptions.ProductNotFoundException;
import org.example.ventory.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public Product createNewProduct(Product product) {
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

    public Product updateProduct(Long id, Product updateProduct) {
        Product existingProduct = productRepository.findById(id)
            .orElseThrow();

        existingProduct.setName(updateProduct.getName());
        existingProduct.setPrice(updateProduct.getPrice());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
    }
}
