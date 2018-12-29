package com.chapter4.jackson;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {
		System.out.println("App.....");
		packages("com.chapter4.jackson")
			.register(MyObjectMapperProvider.class)  // No need to register this provider if no special configuration is required.
			.register(JacksonFeature.class);
	}
}