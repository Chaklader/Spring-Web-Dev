package com.dev.backend.service;

import com.dev.backend.dao.CustomerDao;
import com.dev.backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private static final String CUSTOMER_SUCCESSFULLY_DELETED = "Customer successfully deleted.";

    @Autowired
    private CustomerDao customerDao;

    /**
     * Creates a new Customer or updates if there was one previously created.
     *
     * @param customer Customer provided by the associated resource.
     * @return The created or updated Customer.
     */
    @Transactional
    public Customer saveCustomer(Customer customer)  {
        customerDao.create(customer);
        return customer;
    }

    /**
     * Retrieves all Customers.
     *
     * @return a List containing all Customers.
     */
    @Transactional
    public List<Customer> getCustomers()  {
        return customerDao.findAll();
    }

    /**
     * Retrieves a specific Customer with code equals to the one provided.
     *
     * @param code String to search for.
     * @return a Customer matching provided code.
     */
    @Transactional
    public Customer getCustomer(String code)  {
        return customerDao.findByCode(code);
    }

    /**
     * Deletes a specific Customer with code equals to the one provided.
     *
     * @param code String to search for.
     * @return a String message.
     */
    @Transactional
    public String deleteCustomer(String code)  {
        Customer customer = customerDao.findByCode(code);
        customerDao.delete(customer);
        return CUSTOMER_SUCCESSFULLY_DELETED;
    }

}
