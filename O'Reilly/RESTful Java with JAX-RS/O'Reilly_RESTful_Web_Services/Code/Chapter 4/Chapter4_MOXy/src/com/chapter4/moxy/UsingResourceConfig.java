package com.chapter4.moxy;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;


public class UsingResourceConfig extends ResourceConfig {
	
	public UsingResourceConfig() {
		System.out.println("App.....");
		packages("com.chapter4.moxy").register(new JsonMoxyConfigurationContextResolver());
	}
	
	@Provider
	final static class JsonMoxyConfigurationContextResolver implements
			ContextResolver<MoxyJsonConfig> {

		@Override
		public MoxyJsonConfig getContext(Class<?> objectType) {
			final MoxyJsonConfig configuration = new MoxyJsonConfig();

			Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
			namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");

			configuration.setNamespacePrefixMapper(namespacePrefixMapper);
			configuration.setNamespaceSeparator(':');

			return configuration;
		}
	}
}