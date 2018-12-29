package com.dev.backend.rest;


import com.dev.backend.model.SalesOrder;
import com.dev.backend.rest.wrapper.CommonResponse;
import com.dev.backend.rest.wrapper.SalesOrderRequest;
import com.dev.backend.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/salesorder",
        consumes = "application/json",
        produces = "application/json")
public class SalesOrderResource {
    @Autowired
    private SalesOrderService salesOrderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SalesOrder> createSalesOrder(@Valid @RequestBody SalesOrderRequest salesOrderRequest) {
        return new ResponseEntity<>(salesOrderService.saveSalesOrder(salesOrderRequest), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SalesOrder>> listSalesOrders() {
        return new ResponseEntity<>(salesOrderService.getSalesOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "{orderNumber}", method = RequestMethod.GET)
    public ResponseEntity<SalesOrder> viewSalesOrder(@PathVariable String orderNumber) {
        return new ResponseEntity<>(salesOrderService.getSalesOrder(orderNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "{orderNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteSalesOrder(@PathVariable String orderNumber) {
        String message = salesOrderService.deleteSalesOrder(orderNumber);
        return new ResponseEntity<>(new CommonResponse(message), HttpStatus.OK);
    }

}
