package com.halyph.rest;

import com.halyph.util.annotation.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestService
@Path("/exception")
public class ExceptionResource {

    public ExceptionResource() { }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generateException() throws Exception {
        throw new Exception("generateException from ExceptionResource");
    }
}
