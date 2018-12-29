package com.chapter4.jaxb;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.chapter4.shared.User;
import com.chapter4.shared.UserWithoutAnnotation;

public class ResourceClient {
	
	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:8080/Chapter4_XML/services/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newClient();
		
		client = ClientBuilder.newBuilder()
		        .build();
	}
	
	public static void main(String[] args) {
		ResourceClient resourceClient = new ResourceClient();
		
	    resourceClient.callGetMethod();
	    resourceClient.callGetMethod2();
	}
	
	public void callGetMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jaxbResource");
		
		
		GenericType<User[]> userListGenericType = new GenericType<User[]>() {};
		User[] responseData = target.request(MediaType.APPLICATION_XML).get(userListGenericType);
		for(User  user : responseData)
		{
			System.out.println("Response Data: " + user);
		}
	}
	
	public void callGetMethod2(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "jaxbResource/withoutAnnotation");
		
		GenericType<JAXBElement<UserWithoutAnnotation>> userType = new GenericType<JAXBElement<UserWithoutAnnotation>>() {};
		UserWithoutAnnotation user = (UserWithoutAnnotation) target.request(MediaType.APPLICATION_XML_TYPE).get(userType).getValue();
		System.out.println("Response Data: " + user);
		
//		System.out.println(target.request(MediaType.APPLICATION_XML_TYPE).get(String.class));
		
	}
}
