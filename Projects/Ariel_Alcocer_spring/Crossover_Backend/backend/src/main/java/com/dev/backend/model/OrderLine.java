package com.dev.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_line_id")
    private Long id;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "sales_order_id", nullable = false)
    @JsonBackReference
    private SalesOrder salesOrder;

    public OrderLine(Product product, Integer quantity, BigDecimal unitPrice, BigDecimal totalPrice, SalesOrder salesOrder) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salesOrder = salesOrder;
    }

    public OrderLine(Product product, Integer quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public OrderLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }
}
