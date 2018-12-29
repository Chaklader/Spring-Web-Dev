package com.chapter2;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/deleteResource")
public class DeleteResource {
	@DELETE
    public String delete( @QueryParam("name") String name){
    	System.out.println("delete:");
    	System.out.println("Name: " + name);
    	return "Delete " + name;
    }
}
