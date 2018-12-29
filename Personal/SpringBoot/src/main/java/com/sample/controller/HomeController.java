package com.sample.controller;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController{

    @GetMapping("/")
    public String index() {
        return "index";
    }
}