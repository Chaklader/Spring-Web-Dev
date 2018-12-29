package com.chapter5.sse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

public class ResourceClient {

	public static void main(String[] args) {

		Client client = 
				ClientBuilder
				.newBuilder()
		        .register(SseFeature.class).build();
		WebTarget target = client.target("http://localhost:8080/Chapter5_Server_Sent_Event/services/sseResource/sseEvents");

		final EventSource eventSource = new EventSource(target) {
			@Override
			public void onEvent(InboundEvent inboundEvent) {
				try {
					System.out.println("Data Received: " + inboundEvent.getData(String.class));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
}
