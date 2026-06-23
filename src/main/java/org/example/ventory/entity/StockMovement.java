package org.example.ventory.entity;

import jakarta.persistence.*;
import org.example.ventory.enums.MovementType;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    private Integer quantity;

    private Integer stockBefore;

    private Integer stockAfter;

    private String notes;

    private LocalDateTime createAt;

    public StockMovement() {
    }

    public Product getProduct() {
        return product;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getStockBefore() {
        return stockBefore;
    }

    public Integer getStockAfter() {
        return stockAfter;
    }

    public String getNotes() {
        return notes;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStockBefore(Integer stockBefore) {
        this.stockBefore = stockBefore;
    }

    public void setStockAfter(Integer stockAfter) {
        this.stockAfter = stockAfter;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
