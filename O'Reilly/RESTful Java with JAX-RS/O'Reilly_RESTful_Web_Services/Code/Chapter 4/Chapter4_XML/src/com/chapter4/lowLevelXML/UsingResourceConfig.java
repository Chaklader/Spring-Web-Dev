package com.chapter4.lowLevelXML;

import org.glassfish.jersey.server.ResourceConfig;

public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {
		System.out.println("App.....");
		packages("com.chapter4.lowLevelXML;com.chapter4.jaxb");
	}
}