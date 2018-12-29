package com.resteasy.series.upload.download.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class FileServiceImpl implements IFileService {

	public static final String UPLOAD_FILE_SERVER = "D:/Demo/upload/";

	public Response downloadZippedFile() {

		// set file (and path) to be download
		File file = new File("D:/Demo/download/Sample.zip");

		ResponseBuilder responseBuilder = Response.ok((Object) file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"MyExcelFile.zip\"");
		return responseBuilder.build();
	}

	public Response uploadZippedFile(MultipartFormDataInput multipartFormDataInput) {

		// local variables
		MultivaluedMap<String, String> multivaluedMap = null;
		String fileName = null;
		InputStream inputStream = null;
		String uploadFilePath = null;

		try {
			Map<String, List<InputPart>> map = multipartFormDataInput.getFormDataMap();
			List<InputPart> lstInputPart = map.get("uploadedFile");

			for(InputPart inputPart : lstInputPart){

				// get filename to be uploaded
				multivaluedMap = inputPart.getHeaders();
				fileName = getFileName(multivaluedMap);

				if(null != fileName && !"".equalsIgnoreCase(fileName)){

					// write & upload file to UPLOAD_FILE_SERVER
					inputStream = inputPart.getBody(InputStream.class,null);
					uploadFilePath = writeToFileServer(inputStream, fileName);

					// close the stream
					inputStream.close();
				}
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			// release resources, if any
		}
		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileName
	 * @throws IOException 
	 */
	private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;

		try {
			outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally{
			//release resource, if any
			outputStream.close();
		}
		return qualifiedUploadFilePath;
	}

	/**
	 * 	
	 * @param multivaluedMap
	 * @return
	 */
	private String getFileName(MultivaluedMap<String, String> multivaluedMap) {

		String[] contentDisposition = multivaluedMap.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {

			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String exactFileName = name[1].trim().replaceAll("\"", "");
				return exactFileName;
			}
		}
		return "UnknownFile";
	}
}