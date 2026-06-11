package org.example.ventory.service;

import jakarta.validation.Valid;
import org.example.ventory.dto.ProductRequestDTO;
import org.example.ventory.dto.ProductResponseDTO;
import org.example.ventory.entity.Product;
import org.example.ventory.exception.ProductNotFoundException;
import org.example.ventory.mapper.ProductMapper;
import org.example.ventory.repository.ProductRepository;
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

    public ProductResponseDTO createNewProduct(@Valid ProductRequestDTO requestDTO) {
        Product productEntity = ProductMapper.toEntity(requestDTO);

        Product savedProduct = productRepository.save(productEntity);

        return ProductMapper.toDTO(savedProduct);
    }

    public List<ProductResponseDTO> findByName(String name) {
        return productRepository.findByName(name)
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
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
