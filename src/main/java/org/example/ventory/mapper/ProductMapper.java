package org.example.ventory.mapper;

import org.example.ventory.dto.ProductRequestDTO;
import org.example.ventory.dto.ProductResponseDTO;
import org.example.ventory.entity.Category;
import org.example.ventory.entity.Product;
import org.example.ventory.entity.Supplier;
import org.example.ventory.repository.CategoryRepository;
import org.example.ventory.repository.SupplierRepository;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().getName(),
                product.getSupplier().getName()
        );
    }

    public static Product toEntity(ProductRequestDTO requestDTO,
                                   CategoryRepository categoryRepository,
                                   SupplierRepository supplierRepository
    ) {
        Product product = new Product();
        product.setName(requestDTO.name());
        product.setPrice(requestDTO.price());

        Category category = categoryRepository.findById(
            requestDTO.categoryId()
        ).orElseThrow();
        product.setCategory(category);

        Supplier supplier = supplierRepository.findById(
            requestDTO.supplierId()
        ).orElseThrow();
        product.setSupplier(supplier);

        return product;
    }
}
