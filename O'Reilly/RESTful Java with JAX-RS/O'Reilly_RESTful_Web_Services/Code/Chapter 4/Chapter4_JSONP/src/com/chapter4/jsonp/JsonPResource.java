package com.chapter4.jsonp;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("jsonPResource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JsonPResource {

	@GET
    public JsonArray getAll() {

		JsonObjectBuilder documentBuilder = Json.createObjectBuilder();
		documentBuilder.add("1", "John");
		documentBuilder.add("2", "Williams");
		documentBuilder.add("3", "Suzzane");
		JsonObject document = documentBuilder.build();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(document);
        return arrayBuilder.build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject echoObject(JsonObject jo) {
		System.out.println("JsonObject: " + jo);
        return jo;
    }
}
