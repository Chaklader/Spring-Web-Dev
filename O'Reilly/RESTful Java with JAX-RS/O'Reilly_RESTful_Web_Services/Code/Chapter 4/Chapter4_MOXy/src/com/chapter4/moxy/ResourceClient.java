package com.chapter4.moxy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import com.chapter4.moxy.UsingResourceConfig.JsonMoxyConfigurationContextResolver;
import com.chapter4.shared.User;

public class ResourceClient {

	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newClient();
		
		client = ClientBuilder.newBuilder()
		        // The line bellow that registers MOXy feature can be
		        // omitted if FEATURE_AUTO_DISCOVERY_DISABLE is
		        // not disabled.
		        .register(MoxyJsonFeature.class)
		        .register(JsonMoxyConfigurationContextResolver.class)
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
		WebTarget target = client.target(HOST_NAME + "Chapter4_MOXy/services/userResource");
		
		User bean = target.request(MediaType.APPLICATION_JSON).get(User.class);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
	}
	
	public void callPostMethod(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter4_MOXy/services/userResource");
		User bean1 = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(new User(200,"Williams"), MediaType.APPLICATION_JSON),User.class) ;
		System.out.println(bean1.getId());
		System.out.println(bean1.getName());
	}
}
