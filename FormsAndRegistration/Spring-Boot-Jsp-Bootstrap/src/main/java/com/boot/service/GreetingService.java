package com.boot.service;

import com.boot.entity.Greeting;

import java.util.List;

/**
 * Created by Chaklader on Sep, 2017
 */
public interface GreetingService {

    List<Greeting> findAll();

    void save(Greeting greeting);
}
