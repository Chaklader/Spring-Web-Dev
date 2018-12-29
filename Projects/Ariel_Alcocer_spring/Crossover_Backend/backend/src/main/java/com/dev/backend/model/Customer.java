package com.dev.backend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;
    @NotEmpty
    @Column(name = "address", nullable = false)
    private String address;
    @NotEmpty
    @Column(name = "phone1", nullable = false)
    private String phone1;
    @NotEmpty
    @Column(name = "phone2", nullable = false)
    private String phone2;
    @NotNull
    @Min(0)
    @Column(name = "credit_limit", nullable = false)
    private BigDecimal creditLimit;
    @NotNull
    @Min(0)
    @Column(name = "current_credit", nullable = false)
    private BigDecimal currentCredit;

    public Customer(Long id, String code, String name, String address, String phone1, String phone2, BigDecimal creditLimit, BigDecimal currentCredit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.creditLimit = creditLimit;
        this.currentCredit = currentCredit;
    }

    public Customer() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(BigDecimal currentCredit) {
        this.currentCredit = currentCredit;
    }
}
