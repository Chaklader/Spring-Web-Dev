package test.resteasy.series.upload.download.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

public class TestUploadFileService {

	public static void main(String []args) throws Exception {

		// set file upload parameters
		String httpURL = "http://localhost:9090/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/upload/doc";
		File filePath = new File("D:/Demo/download/Sample.docx");
		String filename = "MyDocumentSample.docx";

		// invoke file upload service using above parameters
		String responseString = testUploadService(httpURL, filePath, filename);
		System.out.println("responseString : " + responseString);
	}

	/**
	 * using ClientRequest and ClientResponse classes from org.jboss.resteasy.client
	 * @param httpURL
	 * @return responseString
	 * @throws IOException
	 */
	@SuppressWarnings({ "deprecation" })
	public static String testUploadService(String httpURL, File filePath, String filename) throws IOException {

		// local variables
		ClientRequest clientRequest = null;
		ClientResponse<?> clientResponse = null;
		MultipartFormDataOutput multipartFormDataOutput = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;

		try{
			// invoke service after setting necessary parameters
			clientRequest = new ClientRequest(httpURL);
			clientRequest.setHttpMethod(HttpMethod.POST);
			clientRequest.header("Content-Type", MediaType.MULTIPART_FORM_DATA);

			// set file upload values
			multipartFormDataOutput = new MultipartFormDataOutput();
			multipartFormDataOutput.addFormData("uploadedFile", new FileInputStream(filePath), MediaType.MULTIPART_FORM_DATA_TYPE, filename);

			// set POST request body and invoke the service
			clientRequest.body(MediaType.MULTIPART_FORM_DATA_TYPE, multipartFormDataOutput);
			clientResponse = clientRequest.post();

			// get response code
			responseCode = clientResponse.getResponseStatus().getStatusCode();
			System.out.println("Response code: " + responseCode);

			if(clientResponse.getResponseStatus().getStatusCode() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = clientResponse.getResponseStatus().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// get response string
			responseString = clientResponse.getEntity(String.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			clientResponse.close();
			clientRequest.clear();
		}
		return responseString;
	}
}