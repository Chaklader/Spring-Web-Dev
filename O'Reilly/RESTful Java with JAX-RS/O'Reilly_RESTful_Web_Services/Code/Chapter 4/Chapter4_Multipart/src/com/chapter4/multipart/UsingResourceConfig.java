package com.chapter4.multipart;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {

		System.out.println("App.....");
		packages("com.chapter4.multipart")
		.register(MultiPartFeature.class);
	}
}