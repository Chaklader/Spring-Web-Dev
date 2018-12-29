package com.halyph.service;

import com.halyph.entity.User;

import javax.ws.rs.core.Response;
import java.util.Collection;

public interface UserService {

    Collection<User> getUsers();

    User getUser(Integer id);

    Response add(User user);

}