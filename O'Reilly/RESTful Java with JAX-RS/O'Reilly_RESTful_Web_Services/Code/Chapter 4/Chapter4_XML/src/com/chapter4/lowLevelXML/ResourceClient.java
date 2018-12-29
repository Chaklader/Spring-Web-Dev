package com.chapter4.lowLevelXML;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.chapter4.shared.User;

public class ResourceClient {
	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/Chapter4_XML/services/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newBuilder()
		        .build();
	}
	
	public static void main(String[] args) {
		ResourceClient resourceClient = new ResourceClient();
		
	    resourceClient.callPostMethodWithStreamSource();
	    resourceClient.callPostMethodWithSAXSource();
	    resourceClient.callPostMethodWithDOMSource();
	    resourceClient.callPostMethodWithDocument();
	}
	
	public void callPostMethodWithStreamSource(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "userResource/usingStreamSource");
		
		User bean1 = target.request(MediaType.APPLICATION_XML).post(Entity.entity(new User(200,"Williams"), MediaType.APPLICATION_XML),User.class) ;
		System.out.println(bean1.getId());
		System.out.println(bean1.getName());
	}
	
	public void callPostMethodWithSAXSource(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "userResource/usingSAXSource");
		
		User bean1 = target.request(MediaType.APPLICATION_XML).post(Entity.entity(new User(200,"Williams"), MediaType.APPLICATION_XML),User.class) ;
		System.out.println(bean1.getId());
		System.out.println(bean1.getName());
	}
	
	public void callPostMethodWithDOMSource(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "userResource/usingDOMSource");
		
		User bean1 = target.request(MediaType.APPLICATION_XML).post(Entity.entity(new User(200,"Williams"), MediaType.APPLICATION_XML),User.class) ;
		System.out.println(bean1.getId());
		System.out.println(bean1.getName());
	}
	
	public void callPostMethodWithDocument(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "userResource/usingDocument");
		
		User bean1 = target.request(MediaType.APPLICATION_XML).post(Entity.entity(new User(200,"Williams"), MediaType.APPLICATION_XML),User.class) ;
		System.out.println(bean1.getId());
		System.out.println(bean1.getName());
	}
}
