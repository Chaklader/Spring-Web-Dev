package com.github.hburgmeier.jerseyoauth2.rs.impl.rs2.filter;

import javax.inject.Inject;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.github.hburgmeier.jerseyoauth2.api.protocol.IRequestFactory;
import com.github.hburgmeier.jerseyoauth2.rs.api.IRSConfiguration;
import com.github.hburgmeier.jerseyoauth2.rs.api.annotations.AllowedScopes;
import com.github.hburgmeier.jerseyoauth2.rs.api.annotations.OAuth20;
import com.github.hburgmeier.jerseyoauth2.rs.api.token.IAccessTokenVerifier;

@Provider
public class OAuth2FilterFeature implements DynamicFeature {
	
	private final IRSConfiguration config;
	private final IAccessTokenVerifier tokenVerifier;
	private final IRequestFactory requestFactory;

	@Inject
	public OAuth2FilterFeature(IRSConfiguration config, IAccessTokenVerifier tokenVerifier, IRequestFactory requestFactory)
	{
		this.config = config;
		this.tokenVerifier = tokenVerifier;
		this.requestFactory = requestFactory;
	}
	
	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		boolean classAnnotation = resourceInfo.getResourceClass().isAnnotationPresent(OAuth20.class);
		boolean methodAnnotation = resourceInfo.getResourceMethod().isAnnotationPresent(OAuth20.class);
		
		if (classAnnotation || methodAnnotation)
		{
			AllowedScopes scopes = methodAnnotation?resourceInfo.getResourceMethod().getAnnotation(AllowedScopes.class):
				resourceInfo.getResourceClass().getAnnotation(AllowedScopes.class);
			OAuth2RequestFilter filter = new OAuth2RequestFilter(scopes.scopes(), config, tokenVerifier, requestFactory);
			context.register(filter);
		}
	}

}
