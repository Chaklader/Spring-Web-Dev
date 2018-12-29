package com.chapter6;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("services")
public class Application extends ResourceConfig {
    public Application() {
    	super(GetResource.class);
    	property(ServerProperties.WADL_FEATURE_DISABLE, false);
    	System.out.println("Application Loaded...");
    }
}