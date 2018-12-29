package com.chapter2;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/postResource")
public class PostResource {
	@POST
    public void post(String userData) {
        System.out.println("POST: " + userData);
    }
	
	@POST
    public Response postForm(@FormParam("name") String name){
    	System.out.println("Name: " + name);
    	return Response
    			.status(200)
    			.entity("Hello, "+ name)
    			.build();
    }
	
	@POST
	@Path("/usingFormParamWithConsume")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String greet(@FormParam("name") String name) {
		System.out.println(name);
		return "Hello, " + name;
	}
}
