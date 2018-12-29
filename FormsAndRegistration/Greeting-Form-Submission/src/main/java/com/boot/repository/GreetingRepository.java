package com.boot.repository;

import com.boot.entity.Greeting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Chaklader on Sep, 2017
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    @Override
    List<Greeting> findAll();
}
