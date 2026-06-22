package org.example.ventory.dto;

import org.example.ventory.entity.Category;
import org.example.ventory.entity.Supplier;

public record ProductResponseDTO(
       Long id,
       String name,
       Double price,
       String categoryName,
       String supplierName
) {
}
