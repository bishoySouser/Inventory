package org.example.ventory.controller;

import org.example.ventory.model.Product;
import org.example.ventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "bed"));
        productList.add(new Product(2, "bed"));
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return productService.findById(id);
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam(defaultValue = "all") String name) {
        return "Search about the product -> " + name;
    }
}
