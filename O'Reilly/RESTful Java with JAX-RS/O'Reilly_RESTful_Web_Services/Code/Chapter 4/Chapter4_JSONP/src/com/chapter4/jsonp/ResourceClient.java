package com.chapter4.jsonp;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;

public class ResourceClient {
	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/Chapter4_JSONP/services/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newBuilder()
				.register(JsonProcessingFeature.class)
		       .property(JsonGenerator.PRETTY_PRINTING, true)
		        .build();
	}
	
	public static void main(String[] args) {
		ResourceClient resourceClient = new ResourceClient();
		
		//	    GET Method
	    resourceClient.callGetMethod();

	    //		POST Method
	    resourceClient.callPostMethod();
	}
	
	public void callGetMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jsonPResource");
		
		JsonArray jsonArray = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		System.out.println("Response: " + jsonArray);
	}
	
	public void callPostMethod(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jsonPResource");
		JsonObject jsonObject = Json.createObjectBuilder()
                .add("1", "John")
                .add("2", "Williams")
				.add("3", "Suzzane")
                .build();

        JsonObject responseJsonObject = target.request().post(Entity.entity(jsonObject, MediaType.APPLICATION_JSON), JsonObject.class);
        System.out.println("Response: " + responseJsonObject);
	}
}