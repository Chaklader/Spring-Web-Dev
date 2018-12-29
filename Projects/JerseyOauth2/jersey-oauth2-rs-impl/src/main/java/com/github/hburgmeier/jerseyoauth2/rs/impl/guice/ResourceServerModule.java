package com.github.hburgmeier.jerseyoauth2.rs.impl.guice;

import com.github.hburgmeier.jerseyoauth2.api.protocol.IRequestFactory;
import com.github.hburgmeier.jerseyoauth2.protocol.impl.RequestFactory;
import com.google.inject.AbstractModule;

public class ResourceServerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AccessTokenVerifierProvider.class);
		bind(ConfigurationServiceProvider.class);
		bind(RequestFactoryProvider.class);
		
		bind(IRequestFactory.class).to(RequestFactory.class);
	}

}
