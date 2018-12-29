package com.mohsenj.module.user.service;

import java.util.List;

import com.mohsenj.module.user.model.Role;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
