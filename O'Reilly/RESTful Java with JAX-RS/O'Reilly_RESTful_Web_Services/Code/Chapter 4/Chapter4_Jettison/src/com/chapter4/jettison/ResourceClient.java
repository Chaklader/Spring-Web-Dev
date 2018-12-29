package com.chapter4.jettison;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.jettison.JettisonFeature;

public class ResourceClient {

	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/Chapter4_Jettison/services/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newBuilder()
				.register(CustomContextResolver.class)  // if needed
				.register(JettisonFeature.class)
		        .build();
	}
	
	public static void main(String[] args) {

		ResourceClient resourceClient = new ResourceClient();
		
		//	    GET Method
	    resourceClient.callGetMethod();
	    
//	    resourceClient.callGetMethod2();
	}
	
	public void callGetMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jettisonResource");

		GenericType<List<User>> userListGenericType = new GenericType<List<User>>() {};
		List<User> userList = target.request("application/json").get(userListGenericType);
		System.out.println("Response: " + userList);
	}
}