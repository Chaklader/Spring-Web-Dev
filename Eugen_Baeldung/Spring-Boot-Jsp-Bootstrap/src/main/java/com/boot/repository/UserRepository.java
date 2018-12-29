package com.boot.repository;

import com.boot.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Chaklader on Oct, 2017
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
