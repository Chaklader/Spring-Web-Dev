package com.dev.backend.rest.wrapper;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class SalesOrderRequest {
    @NotEmpty
    private String orderNumber;
    @NotNull
    @Min(0)
    private BigDecimal totalPrice;
    @NotEmpty
    private String customer;
    private List<OrderLine> orderLines;

    public SalesOrderRequest(String orderNumber, BigDecimal totalPrice, String customer, List<OrderLine> orderLines) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.orderLines = orderLines;
    }

    public SalesOrderRequest() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public static class OrderLine   {
        @NotEmpty
        private String product;
        @NotNull
        @Min(0)
        private Integer quantity;
        @NotNull
        @Min(0)
        private BigDecimal price;
        @NotNull
        @Min(0)
        private BigDecimal total;

        public OrderLine(String product, Integer quantity, BigDecimal total, BigDecimal price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
            this.total = total;
        }

        public OrderLine() {
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }

    }
}
