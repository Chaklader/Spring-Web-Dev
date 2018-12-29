//package com.boot.controller;
//
//import com.boot.entity.User;
//import com.boot.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * Created by Chaklader on Oct, 2017
// */
//@Controller
//public class UserController {
//
//    private final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserService userService;
//
//
//    private static List<User> populateDefaultUserValues() {
//
//        List<User> users = new ArrayList<>();
//
//        User user = new User();
//        user.setName("Ella");
//        user.setEmail("xyz@gmail.com");
//        user.setPassword("df32d343H");
//        user.setFramework(Arrays.asList("Spring MVC, GWT".split("\\s*,\\s*")));
//        users.add(user);
//
//
//        user = new User();
//        user.setName("Alex");
//        user.setEmail("alex@hotmail.com");
//        user.setPassword("12HH2d343H");
//        user.setFramework(Arrays.asList("Spring MVC, GWT".split("\\s*,\\s*")));
//        users.add(user);
//
//
//        user = new User();
//        user.setName("KKomanna");
//        user.setEmail("romanna@hotmail.com");
//        user.setPassword("Rommann343");
//        user.setFramework(Arrays.asList("Spring MVC, GWT".split("\\s*,\\s*")));
//        users.add(user);
//
//        return users;
//    }
//
//    @GetMapping(value = "/")
//    public String index() {
//        return "redirect:/users";
//    }
//
//    @GetMapping(value = "/users")
//    public String showAllUsers(Model model) {
//
//        List<User> users = populateDefaultUserValues();
//
//        users.forEach(user -> {
//            userService.save(user);
//        });
//
////        System.out.println("/n/n/n/n" + (userService.findAll()).stream().map(Object::toString)
////                .collect(Collectors.joining(", ")) + "/n/n/n/n");
//
//        model.addAttribute("users", userService.findAll());
//        return "list";
//    }
//}
