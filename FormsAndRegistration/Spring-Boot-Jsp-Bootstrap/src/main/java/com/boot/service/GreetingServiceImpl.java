package com.boot.service;

import com.boot.entity.Greeting;
import com.boot.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chaklader on Sep, 2017
 */
@Service
public class GreetingServiceImpl implements GreetingService{

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public List<Greeting> findAll() {
        return greetingRepository.findAll();
    }

    @Override
    public void save(Greeting greeting) {
        greetingRepository.save(greeting);
    }
}
