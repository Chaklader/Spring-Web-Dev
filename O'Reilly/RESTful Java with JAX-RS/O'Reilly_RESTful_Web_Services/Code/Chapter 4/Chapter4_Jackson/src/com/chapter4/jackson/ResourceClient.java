package com.chapter4.jackson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

public class ResourceClient {

	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/Chapter4_Jackson/services/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newBuilder()
				.register(MyObjectMapperProvider.class)  // No need to register this provider if no special configuration is required.
		        .register(JacksonFeature.class)
		        .build();
	}
	
	public static void main(String[] args) {
		ResourceClient resourceClient = new ResourceClient();
		
		//	    GET Method
	    resourceClient.callGetMethod();
	    
	    resourceClient.callGetMethod2();
	}
	
	public void callGetMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jacksonResource");
		
		User user = target.request(MediaType.APPLICATION_JSON).get(User.class);
		System.out.println("Response: " + user);
	}
	
	public void callGetMethod2(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jacksonResource/getUserBean");
		
		UserBean userBean = target.request(MediaType.APPLICATION_JSON).get(UserBean.class);
		System.out.println("Response: " + userBean);
	}
}