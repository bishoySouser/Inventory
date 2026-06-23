package org.example.ventory.service;

import jakarta.transaction.Transactional;
import org.example.ventory.entity.Product;
import org.example.ventory.enums.MovementType;
import org.example.ventory.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;

    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Transactional
    public void updateStock(Product product, Integer quantity, MovementType movementType) {

    }
}
