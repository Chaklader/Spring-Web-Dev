package com.chapter3;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("personResource")
public class PersonResource {

	@POST
    @Consumes(value=Person.PERSON_MIME_TYPE)
    public String getFruit(Person person) {
        return "Id: " + person.getId() + ", Name: " + person.getName();
    }
}