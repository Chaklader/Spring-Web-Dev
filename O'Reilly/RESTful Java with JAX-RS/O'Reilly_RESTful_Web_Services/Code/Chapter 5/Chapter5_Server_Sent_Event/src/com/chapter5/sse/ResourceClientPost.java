package com.chapter5.sse;

import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class ResourceClientPost {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/Chapter5_Server_Sent_Event/services/sseResource");
		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<String, String>();
		postForm.add("name", "John: " + UUID.randomUUID().toString());
		String responseData = target.request().post(Entity.form(postForm),String.class) ;
		System.out.println("Response Data: " + responseData);
	}
}
