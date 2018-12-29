package com.github.hburgmeier.jerseyoauth2.testsuite.base;

import javax.xml.bind.annotation.XmlRootElement;

import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IPendingClientToken;

@XmlRootElement
public class ClientAuthEntity {

	private String code;

	public ClientAuthEntity()
	{
	}
	
	public ClientAuthEntity(IPendingClientToken clientAuthorization) {
		super();
		this.code = clientAuthorization.getCode();
	}
	
	public String getCode()
	{
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
