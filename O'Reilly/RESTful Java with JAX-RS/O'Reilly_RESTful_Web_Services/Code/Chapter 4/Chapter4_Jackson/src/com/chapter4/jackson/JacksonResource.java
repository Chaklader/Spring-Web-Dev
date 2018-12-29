package com.chapter4.jackson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("jacksonResource")
public class JacksonResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        return new User(1, "John");
    }
	
	
	@GET
	@Path("getUserBean")
    @Produces(MediaType.APPLICATION_JSON)
    public UserBean getUserBean() {
        return new UserBean(1, "John");
    }
}