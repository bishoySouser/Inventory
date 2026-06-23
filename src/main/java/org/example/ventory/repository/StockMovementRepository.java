package org.example.ventory.repository;

import org.example.ventory.entity.Product;
import org.example.ventory.entity.StockMovement;
import org.example.ventory.enums.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    public void updateStock(Product product, Integer quantity, MovementType movementType);
}
