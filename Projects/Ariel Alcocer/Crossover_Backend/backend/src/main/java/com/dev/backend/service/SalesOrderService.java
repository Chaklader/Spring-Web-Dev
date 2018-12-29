package com.dev.backend.service;

import com.dev.backend.dao.CustomerDao;
import com.dev.backend.dao.ProductDao;
import com.dev.backend.dao.SalesOrderDao;
import com.dev.backend.exception.InsufficientCreditException;
import com.dev.backend.exception.InsufficientStockException;
import com.dev.backend.model.Customer;
import com.dev.backend.model.OrderLine;
import com.dev.backend.model.Product;
import com.dev.backend.model.SalesOrder;
import com.dev.backend.rest.wrapper.SalesOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesOrderService {

    private static final String SALES_ORDER_SUCCESSFULLY_DELETED = "Sales order successfully deleted.";

    @Autowired
    private SalesOrderDao salesOrderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;

    /**
     * Creates a new SalesOrder or updates if there was one previously created.
     *
     * @param salesOrderRequest SalesOrderRequest provided by associated resource.
     * @return The created or updated SalesOrder.
     * @throws InsufficientCreditException when Total price of sales order is less than or equal (Customer Credit Limit - Customer Current Credit).
     * @throws InsufficientStockException when Quantities that have been requested are less than or equal current inventory balance.
     */
    @Transactional
    public SalesOrder saveSalesOrder(SalesOrderRequest salesOrderRequest)  throws InsufficientCreditException, InsufficientStockException {
        Customer customer = customerDao.findByCode(salesOrderRequest.getCustomer());
        validateCustomerCredit(salesOrderRequest.getTotalPrice(), customer);
        //Customer credit is updated
        customer.setCurrentCredit(customer.getCurrentCredit().add(salesOrderRequest.getTotalPrice()));

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setOrderNumber(salesOrderRequest.getOrderNumber());
        salesOrder.setCustomer(customer);
        salesOrder.setTotalPrice(salesOrderRequest.getTotalPrice());
        List<OrderLine> orderLines = new ArrayList<>();

        for(SalesOrderRequest.OrderLine reqOrderLine : salesOrderRequest.getOrderLines()) {
            Product product = productDao.findByCode(reqOrderLine.getProduct());
            validateProductStock(reqOrderLine.getQuantity(), product);
            //Stock Quantity is updated
            product.setQuantity(product.getQuantity()-reqOrderLine.getQuantity());

            OrderLine orderLine = new OrderLine(
            product, reqOrderLine.getQuantity(), reqOrderLine.getPrice(), reqOrderLine.getTotal(), salesOrder);
            orderLines.add(orderLine);
        }
        salesOrder.setOrderLines(orderLines);
        salesOrderDao.create(salesOrder);
        return salesOrder;
    }

    /**
     * Validates that Quantities that have been requested are less than or equal current inventory balance.
     *
     * @param quantity Integer provided by SalesOrder request.
     * @param product Product to ask for stock quantity.
     */
    private void validateProductStock(Integer quantity, Product product) {
        if(quantity>product.getQuantity())    {
            throw new InsufficientStockException("Available stock is insufficient to process this sale order.");
        }
    }

    /**
     * Validates if Total price of sales order is less than or equal (Customer Credit Limit - Customer Current Credit).
     *
     * @param totalPrice BigDecimal provided by SalesOrder request.
     * @param customer Customer to ask for credit.
     */
    private void validateCustomerCredit(BigDecimal totalPrice, Customer customer) {
        BigDecimal availableCredit = customer.getCreditLimit().subtract(customer.getCurrentCredit());
        if(totalPrice.compareTo(availableCredit)>0)   {
            throw new InsufficientCreditException("Not enough credit for this sales order.");
        }
    }

    /**
     * Retrieves all SalesOrders.
     *
     * @return a List containing all SalesOrders.
     */
    @Transactional
    public List<SalesOrder> getSalesOrders() {
        return salesOrderDao.findAll();
    }

    /**
     * Retrieves a specific SalesOrder with orderNumber equals to the one provided.
     *
     * @param orderNumber String to search for.
     * @return a SalesOrder matching provided orderNumber.
     */
    @Transactional
    public SalesOrder getSalesOrder(String orderNumber) {
        return salesOrderDao.findByOrderNumber(orderNumber);
    }

    /**
     * Deletes a specific SalesOrder with orderNumber equals to the one provided.
     *
     * @param orderNumber String to search for.
     * @return a String message.
     */
    @Transactional
    public String deleteSalesOrder(String orderNumber) {
        SalesOrder salesOrder = salesOrderDao.findByOrderNumber(orderNumber);
        salesOrderDao.delete(salesOrder);
        return SALES_ORDER_SUCCESSFULLY_DELETED;
    }

}
