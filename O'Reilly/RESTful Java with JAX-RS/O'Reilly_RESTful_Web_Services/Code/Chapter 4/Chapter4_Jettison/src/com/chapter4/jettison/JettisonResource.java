package com.chapter4.jettison;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("jettisonResource")
public class JettisonResource {

	@GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers() {

		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "John"));
		userList.add(new User(2, "Williams"));
		userList.add(new User(3, "Suzanne"));
		System.out.println("UserList: " + userList);
        return userList;
    }
}