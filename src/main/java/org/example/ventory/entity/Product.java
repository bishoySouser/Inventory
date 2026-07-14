package org.example.ventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.ventory.enums.MovementType;
import org.example.ventory.exception.InsufficientStockException;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Column(name = "product_price")
    @Positive
    private Double price;

    @Column(name = "product_quantity")
    @Positive
    private Long quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockMovement> stockMovement = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Product() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<StockMovement> getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(List<StockMovement> stockMovement) {
        this.stockMovement = stockMovement;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void applyMovement(int quantity, MovementType type) {
        if (type == MovementType.IN) {
            this.quantity += quantity;
        } else {
            if (this.quantity < quantity)
                throw new InsufficientStockException("the quantity greater than the stock");
            this.quantity -= quantity;
        }
    }
}
