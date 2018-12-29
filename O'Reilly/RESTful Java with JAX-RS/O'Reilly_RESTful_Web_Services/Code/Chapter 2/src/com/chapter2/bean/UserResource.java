package com.chapter2.bean;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/beanResource")
public class UserResource {
	@GET
    @Path("/get/{id}")
    public String get(@BeanParam UserBean user) {
        return "User Bean: " + user.toString();
    }
}
