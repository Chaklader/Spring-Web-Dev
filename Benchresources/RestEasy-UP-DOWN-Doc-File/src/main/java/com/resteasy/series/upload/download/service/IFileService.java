package com.resteasy.series.upload.download.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/fileservice")
public interface IFileService {

	// http://localhost:8080/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/download/doc  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/download/doc  - JBoss AS7
	@GET
	@Path("/download/doc")
	@Produces("application/msword")
	public Response downloadDocFile();

	// http://localhost:8080/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/upload/doc  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/upload/doc  - JBoss AS7
	@POST
	@Path("/upload/doc")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadDocFile(MultipartFormDataInput multipartFormDataInput);
}