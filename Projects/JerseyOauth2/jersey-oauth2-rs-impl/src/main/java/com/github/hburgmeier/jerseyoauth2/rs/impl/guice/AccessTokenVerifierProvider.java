package com.github.hburgmeier.jerseyoauth2.rs.impl.guice;

import javax.inject.Inject;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.github.hburgmeier.jerseyoauth2.rs.api.token.IAccessTokenVerifier;
import com.google.inject.Singleton;

@Singleton
@Provider
public class AccessTokenVerifierProvider implements ContextResolver<IAccessTokenVerifier>{

	private final IAccessTokenVerifier accessTokenVerifier;

	@Inject
	public AccessTokenVerifierProvider(final IAccessTokenVerifier accessTokenVerifier)
	{
		this.accessTokenVerifier = accessTokenVerifier;
	}
	
	@Override
	public IAccessTokenVerifier getContext(Class<?> type) {
		return this.accessTokenVerifier;
	}


}
