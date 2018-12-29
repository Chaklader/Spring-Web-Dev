package com.boot.service;

import com.boot.entity.Greeting;
import com.boot.entity.User;

import java.util.List;

///**
// * Created by Chaklader on Oct, 2017
// */
public interface UserService {

    List<User> findAll();

    User findById(Long idx);

    void save(User user);

    void delete(Long idx);
}
