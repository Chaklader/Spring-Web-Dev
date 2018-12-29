package com.dev.backend.rest;

import com.dev.backend.model.Product;
import com.dev.backend.rest.wrapper.CommonResponse;
import com.dev.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product",
        consumes = "application/json",
        produces = "application/json")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET)
    public ResponseEntity<Product> viewProduct(@PathVariable String code) {
        return new ResponseEntity<>(productService.getProduct(code), HttpStatus.OK);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteProduct(@PathVariable String code) {
        String message = productService.deleteProduct(code);
        return new ResponseEntity<>(new CommonResponse(message), HttpStatus.OK);
    }


}
