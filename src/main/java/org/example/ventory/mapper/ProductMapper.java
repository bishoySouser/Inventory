package org.example.ventory.mapper;

import org.example.ventory.dto.ProductRequestDTO;
import org.example.ventory.dto.ProductResponseDTO;
import org.example.ventory.entity.Product;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getSupplier()
        );
    }

    public static Product toEntity(ProductRequestDTO requestDTO) {
        Product product = new Product();
        product.setName(requestDTO.name());
        product.setPrice(requestDTO.price());
        product.setCategory(requestDTO.category());
        product.setSupplier(requestDTO.supplier());
        return product;
    }
}
