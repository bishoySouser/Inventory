package org.example.ventory.controller;

import org.example.ventory.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public String index()
    {
        return "Get All products.";
    }

    @GetMapping("/products/{id}")
    public Product show(@PathVariable int id)
    {
        return new Product(id, "Labtop");
    }

    @GetMapping("/products/search")
    public String search(@RequestParam(defaultValue = "all") String name) {
        return "Search about the product -> " + name;
    }
}
