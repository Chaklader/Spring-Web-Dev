package com.chapter4.jettison;

import org.glassfish.jersey.jettison.JettisonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {

		System.out.println("App.....");
		packages("com.chapter4.jettison")
		.register(CustomContextResolver.class)  // if needed
		.register(JettisonFeature.class);
	}
}