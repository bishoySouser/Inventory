package org.example.ventory.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.ventory.entity.Category;
import org.example.ventory.entity.Supplier;

public record ProductRequestDTO(
        @NotBlank(message = "Product name cannot be empty")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @Positive
        Double price,

        Long categoryId,
        Long supplierId
) {
}
