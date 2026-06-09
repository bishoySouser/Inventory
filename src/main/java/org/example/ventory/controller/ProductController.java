package org.example.ventory.controller;

import org.example.ventory.entities.Product;
import org.example.ventory.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id)
    {
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.CreateNewProduct(product);
    }
}
