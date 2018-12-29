package com.chapter3;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * This demostrate how to consume Web Service with different HTTP Methods and *Param Annotation.
 * To run this example, you need require Chapter 2 to be deployed as it contains Server Code that will serve this Resource Client.
 * Deploy both Chapter 2 and Chapter 3 Example on Server and then run this ResourceClient.java
 * 
 * @author Sunil Gulabani
 *
 */
public class ResourceClient {
	private Client client ;
	
	private final static String HOST_NAME = "http://localhost:9191/" ;
	
	public ResourceClient(){
		client = ClientBuilder.newClient();
	}
	
	public static void main(String[] args) {
		ResourceClient resourceClient = new ResourceClient();
		
		//	    GET Method
	    resourceClient.callGetMethod();

	    //	    POST Method
	    resourceClient.callPostMethod();

	    //	    PUT Method
	    resourceClient.callPutMethod();

	    //	    Delete Method
	    resourceClient.callDeleteMethod();
	    
	    //	    Path Parameter
	    resourceClient.callGetMethodUsingPathParam();

	    //	    Query Parameter alongwith Header Parameter
	    resourceClient.callGetMethodUsingQueryParam();
	    
	    //	    Cookie Parameter
	    resourceClient.callGetMethodToGetCookieValues();
	    
	    //	    Matrix Parameter
	    resourceClient.callGetMethodUsingMatrixParam();

	    //	    Bean Parameter
		resourceClient.callBeanParam();
		
	    //	    @Produces
		resourceClient.callProduceMethod();
		
	    //	    @Consumes
		resourceClient.callConsumeMethod();
		
		//		Using COntext URI in 
		resourceClient.callGetMethodUsingContextURI();
	
		//		MessageBodyReader<T> & MessageBodyWriter<T>
		resourceClient.callMyObject();
	}
	
	public void callGetMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource");
		String responseData = target.request().get(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callPostMethod(){
		System.out.println();
		System.out.println("--------------------------------------------------- POST Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/postResource");
		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
		postForm.add("name", "John");
		String responseData = target.request().post(Entity.form(postForm),String.class) ;
		System.out.println("Response Data: " + responseData);
	}
	
	public void callPutMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- PUT Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/putResource");
		MultivaluedMap<String, String> putForm = new MultivaluedHashMap<String, String>();
		putForm.add("name", "John");
		String responseData = target.request().put(Entity.form(putForm),String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callDeleteMethod(){
		System.out.println();
		System.out.println("------------------------------------------------- Delete Method -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/deleteResource?name=John%20Doe");
		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
		postForm.add("name", "John");
		String responseData = target.request().delete(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callGetMethodUsingPathParam(){
		System.out.println();
		System.out.println("------------------------------------------ Get Method Using Path Param ------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource");
		String responseData = 
								target
									.path("{id}")
									.resolveTemplate("id", "1001")
									.request()
									.get(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callGetMethodUsingQueryParam(){
		System.out.println();
		System.out.println("------------------------------------------ Get Method Using Query Param -----------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource");
		String responseData = 
								target
								.path("subResource")
								.queryParam("id", 1)
								.queryParam("name", "John")
								.request().get(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callGetMethodToGetCookieValues(){
		System.out.println();
		System.out.println("-------------------------------------------------- Cookie Param -------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource/getSessionId");
		Cookie cookie = new Cookie("sessionid", "100");
		Invocation invocation = target.request("text/plain").cookie(cookie).buildGet();
		
		String responseData = invocation.invoke(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callGetMethodUsingMatrixParam(){
		System.out.println();
		System.out.println("------------------------------------------ Get Method Using Matrix Param ----------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource");
		String responseData = 
								target
								.path("usingMatrixParam")
								.matrixParam("id", 1)
								.matrixParam("name", "John")
								.request().get(String.class);
		System.out.println("Response Data: " + responseData);
	}
	
	public void callBeanParam(){
		System.out.println();
		System.out.println("-------------------------------------------------- Bean Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/beanResource/get/101;name=John;age=25?address=USA");
		String responseData = target.request().get(String.class);
		System.out.println("Response Data: " + responseData.toString());
	}
	
	public void callProduceMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Produce Method -----------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/getResource/getUserList");
		String responseData = target.request().get(String.class);
		System.out.println("Response Data: " + responseData);
	}

	public void callConsumeMethod(){
		System.out.println();
		System.out.println("-------------------------------------------------- Consume Method -----------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services/postResource/usingFormParamWithConsume");
		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
		postForm.add("name", "John");
		String responseData = target.request().post(Entity.form(postForm),String.class) ;
		System.out.println("Response Data: " + responseData);
	}
	
	public void callGetMethodUsingContextURI(){
		System.out.println();
		System.out.println("-------------------------------------------------- Get Method ---------------------------------------------------");
		WebTarget target = client.target(HOST_NAME + "Chapter2/services");
		target = target.path("getResource");
		
		Response response = target.request().get();
		String responseData = response.readEntity(String.class);
		
		System.out.println("Response Data: " + responseData);
	}

	public void callMyObject() {
		System.out.println();
		System.out.println("----------------------------------------------- Custom Object Method --------------------------------------------");

		Client client = ClientBuilder.newClient();
        client
                .register(PersonReader.class)
                .register(PersonWriter.class);
        WebTarget target = client.target(HOST_NAME + "Chapter3/services/personResource");
        String responseData = target
                .request()
                .post(Entity.entity(new Person(1,"John"), Person.PERSON_MIME_TYPE), String.class);
        System.out.println("Response Data: " + responseData);
	}
}