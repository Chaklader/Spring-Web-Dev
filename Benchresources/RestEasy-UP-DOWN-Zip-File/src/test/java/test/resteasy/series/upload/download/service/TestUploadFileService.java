package test.resteasy.series.upload.download.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

public class TestUploadFileService {

	public static void main(String []args) throws Exception {

		// set file upload parameters
		String httpURL = "http://localhost:9090/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/upload/zip";
		File filePath = new File("D:/Demo/download/Sample.zip");
		String filename = "MyZipSample.zip";

		// invoke file upload service using above parameters
		String responseString = testUploadService(httpURL, filePath, filename);
		System.out.println("responseString : " + responseString);
	}

	/**
	 * using Client, WebTarget from core JAX-RS classes javax.ws.rs.client
	 * @param url
	 */
	public static String testUploadService(String httpURL, File filePath, String filename) throws IOException {

		// local variables
		Client client = null;
		WebTarget webTarget = null;
		Builder builder = null;
		MultipartFormDataOutput multipartFormDataOutput = null;
		GenericEntity<MultipartFormDataOutput> genericEntity = null;
		Response response = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;

		try {
			// invoke service after setting necessary parameters
			client = ClientBuilder.newClient();
			webTarget = client.target(httpURL);
			client.property("Content-Type", MediaType.MULTIPART_FORM_DATA);
			builder = webTarget.request();

			// set file upload values
			multipartFormDataOutput = new MultipartFormDataOutput();
			multipartFormDataOutput.addFormData("uploadedFile", new FileInputStream(filePath), MediaType.MULTIPART_FORM_DATA_TYPE, filename);
			genericEntity = new GenericEntity<MultipartFormDataOutput>(multipartFormDataOutput) { };

			// invoke service
			response = builder.post(Entity.entity(genericEntity, MediaType.MULTIPART_FORM_DATA_TYPE));

			// get response code
			responseCode = response.getStatus();
			System.out.println("Response code: " + responseCode);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// get response string
			responseString = response.readEntity(String.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			response.close();
			client.close();
		}
		return responseString;
	}
}