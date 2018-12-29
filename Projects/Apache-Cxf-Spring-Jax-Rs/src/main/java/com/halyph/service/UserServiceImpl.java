package com.halyph.service;

import com.halyph.entity.User;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    static {
        users.put(1, new User(1, "foo"));
        users.put(2, new User(2, "bar"));
        users.put(3, new User(3, "baz"));
    }

    public UserServiceImpl() {
    }

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    @Override
    public Response add(User user) {
        user.setId(users.size()+1);
        users.put(user.getId(), user);

        //do more stuff to add user to the system..
        return Response.status(Response.Status.OK).build();
    }

}