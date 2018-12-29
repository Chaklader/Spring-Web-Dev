package com.chapter2;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/getResource")
public class GetResource {
	@GET
	public String get() {
		System.out.println("Hello World!!!");
		return "Hello World!!!";
	}

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id) {
		return Response.status(200).entity("Id: " + id).build();
	}

	@GET
	@Path("usingMatrixParam")
	public Response usingMatrixParam(
			@DefaultValue("0") @MatrixParam("id") String id,
			@DefaultValue("No Name") @MatrixParam("name") String name) {
		System.out.println("");
		return Response.status(200).entity("Id: " + id + ", Name: " + name)
				.build();
	}

	@GET
	@Path("/subResource")
	public Response usingQueryParam(
			@DefaultValue("0") @QueryParam("id") String id,
			@DefaultValue("No Name") @QueryParam("name") String name,
			@DefaultValue("0") @QueryParam("age") String age,
			@HeaderParam("user-agent") String userAgent) {
		return Response
				.status(200)
				.entity("Id: " + id + ", Name: " + name + ", Age: " + age
						+ ", User-Agent: " + userAgent).build();
	}

	@GET
	@Path("/getSessionId")
	public String getSessionId(@CookieParam("sessionid") int sessionId) {
		System.out.println("Session Id: " + sessionId);
		return 
				"Session Id: " + sessionId ;
	}
	
	@GET
	@Path("/getUserList")
	@Produces({ "application/xml" })
	public User[] getList() {
		User[] list = new User[3];
		list[0] = new User("John");
		list[1] = new User("Willian");
		list[2] = new User("Suzzane");

		return list;
	}
}