package com.dev.backend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Long id;
    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Min(0)
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @NotNull
    @Min(0)
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Product(Long id, String code, String description, BigDecimal price, Integer quantity) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
