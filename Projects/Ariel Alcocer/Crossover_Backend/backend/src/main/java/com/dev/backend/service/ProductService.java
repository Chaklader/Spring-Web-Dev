package com.dev.backend.service;

import com.dev.backend.model.Product;
import com.dev.backend.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private static final String PRODUCT_SUCCESSFULLY_DELETED = "Product successfully deleted.";

    @Autowired
    private ProductDao productDao;

    /**
     * Creates a new Product or updates if there was one previously created.
     *
     * @param product Product provided by the associated resource.
     * @return The created or updated Product.
     */
    @Transactional
    public Product saveProduct(Product product)  {
        productDao.create(product);
        return product;
    }

    /**
     * Retrieves all SalesOrders.
     *
     * @return a List containing all Products.
     */
    @Transactional
    public List<Product> getProducts()  {
        return productDao.findAll();
    }

    /**
     * Retrieves a specific Product with code equals to the one provided.
     *
     * @param code String to search for.
     * @return a Product matching provided code.
     */
    @Transactional
    public Product getProduct(String code)  {
        return productDao.findByCode(code);
    }

    /**
     * Deletes a specific Product with code equals to the one provided.
     *
     * @param code String to search for.
     * @return a String message.
     */
    @Transactional
    public String deleteProduct(String code)  {
        Product product = productDao.findByCode(code);
        productDao.delete(product);
        return PRODUCT_SUCCESSFULLY_DELETED;
    }

}
