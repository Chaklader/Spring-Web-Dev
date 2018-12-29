package com.chapter5.sse;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;


public class ResourceClientUsingEventInput {

	public static void main(String[] args) {
		
		Client client = ClientBuilder
							.newBuilder()
							.register(SseFeature.class)
							.build();

		WebTarget target = client.target("http://localhost:8080/Chapter5_Server_Sent_Event/services/sseResource/sseEvents");

		EventInput eventInput = target.request().get(EventInput.class);
		while (!eventInput.isClosed()) {
		    final InboundEvent inboundEvent = eventInput.read();
		    if (inboundEvent == null) {
		        break; // connection has been closed
		    }
		    try {
				System.out.println(inboundEvent.getData(String.class));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
