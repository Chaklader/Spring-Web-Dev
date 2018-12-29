package com.boot.service;

import com.boot.entity.User;
import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chaklader on Oct, 2017
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User findById(Long idx) {
        return userRepository.findOne(idx);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long idx) {
        userRepository.delete(idx);
    }
}
