package com.chapter2;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/putResource")
public class PutResource {
	@PUT
    public String put(@FormParam("name") String name){
    	System.out.println("PUT:");
    	System.out.println("Name: " + name);
    	return "Hello, " + name;
    }
}
