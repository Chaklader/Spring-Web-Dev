package com.chapter4.moxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chapter4.shared.User;

@Path("/userResource")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User createSimpleBean() {
		return new User(100,"John");
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User roundTrip(User user) {
		return user;
	}
}
