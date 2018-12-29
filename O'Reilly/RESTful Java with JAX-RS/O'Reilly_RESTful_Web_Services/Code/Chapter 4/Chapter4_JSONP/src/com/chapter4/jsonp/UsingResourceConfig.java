package com.chapter4.jsonp;

import javax.json.stream.JsonGenerator;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {
		System.out.println("App.....");
		packages("com.chapter4.jsonp")
			.register(JsonProcessingFeature.class)
			.property(JsonGenerator.PRETTY_PRINTING, true);
	}
}