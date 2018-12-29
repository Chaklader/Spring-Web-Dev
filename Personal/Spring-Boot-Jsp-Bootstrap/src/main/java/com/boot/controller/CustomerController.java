package com.boot.controller;

import com.boot.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chaklader on Oct, 2017
 */
@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private Map<String, Customer> customers = null;

    public CustomerController(){
        customers = new HashMap<String, Customer>();
    }

    @RequestMapping(value = "/cust/save", method = RequestMethod.GET)
    public String saveCustomerPage(Model model) {
        LOGGER.info("Returning custSave.jsp page");
        model.addAttribute("customer", new Customer());
        return "custSave";
    }

    @PostMapping(value = "/cust/save.do")
    public String saveCustomerAction(@Valid Customer customer, BindingResult bindingResult, Model model){

        // return if the customer is not valid
        if(bindingResult.hasErrors()){
            LOGGER.debug("The customer is not valid");
            return "custSave";
        }

        LOGGER.info("The customer is valid");
        model.addAttribute("customer", customer);
        customers.put(customer.getEmail(), customer);

        return "custSaveSuccess";
    }
}
