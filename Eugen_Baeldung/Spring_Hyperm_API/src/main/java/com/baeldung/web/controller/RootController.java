package com.baeldung.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.web.resource.RootResource;

@RestController
public class RootController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public RootResource root() {
        return new RootResource();
    }

}
