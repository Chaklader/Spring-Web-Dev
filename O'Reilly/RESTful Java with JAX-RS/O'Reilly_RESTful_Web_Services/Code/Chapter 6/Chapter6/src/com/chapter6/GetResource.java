package com.chapter6;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/getResource")
public class GetResource {
	
	@GET
	public String get() {
		System.out.println("Hello World!!!");
		return "Hello World!!!";
	}

	@GET
	@Path("{name}")
	public Response greetUser(@PathParam("name") String name){
		return Response.status(200).entity("Hello, " + name).build();
	}
}