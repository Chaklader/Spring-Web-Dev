package com.github.hburgmeier.jerseyoauth2.authsrv.api.token;

import javax.servlet.http.HttpServletRequest;

import com.github.hburgmeier.jerseyoauth2.api.protocol.IAccessTokenRequest;
import com.github.hburgmeier.jerseyoauth2.api.protocol.OAuth2ProtocolException;
import com.github.hburgmeier.jerseyoauth2.api.protocol.ResponseBuilderException;
import com.github.hburgmeier.jerseyoauth2.api.types.ResponseType;
import com.github.hburgmeier.jerseyoauth2.api.user.IUser;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IAuthorizedClientApp;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.protocol.IOAuth2Response;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.ui.AuthorizationFlowException;

public interface ITokenService {
	
	IOAuth2Response handleRequest(HttpServletRequest request, IAccessTokenRequest oauthRequest)
			throws OAuth2ProtocolException, ResponseBuilderException, AuthorizationFlowException;
	
	IOAuth2Response issueNewToken(HttpServletRequest request, IAuthorizedClientApp clientApp, ResponseType responseType, String state)
			throws OAuth2ProtocolException, ResponseBuilderException;
	
	IOAuth2Response sendTokenResponse(IAccessTokenInfo accessTokenInfo, ResponseType responseType, String state)
			throws ResponseBuilderException;
	
	IOAuth2Response sendErrorResponse(IAccessTokenRequest oauthRequest, OAuth2ProtocolException ex) throws ResponseBuilderException;

	void removeTokensForUser(IUser user);
}
