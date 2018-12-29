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

	// http://localhost:8080/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/download/zip  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/download/zip  - JBoss AS7
	@GET
	@Path("/download/zip")
	@Produces("application/zip")
	public Response downloadZippedFile();

	// http://localhost:8080/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/upload/zip  - Tomcat 7.0.x
	// http://localhost:9090/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/upload/zip  - JBoss AS7
	@POST
	@Path("/upload/zip")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadZippedFile(MultipartFormDataInput multipartFormDataInput);
}