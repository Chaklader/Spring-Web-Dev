package test.resteasy.series.upload.download.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.HttpMethod;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class TestDownloadFileService {

	public static final String DOWNLOAD_FILE_LOCATION = "D:/Demo/test/";

	public static void main(String []args) throws IOException {

		String httpURL = "http://localhost:9090/RestEasy-UP-DOWN-Doc-File/resteasy/fileservice/download/doc";
		String responseString = testDownloadService(httpURL);
		System.out.println("responseString : " + responseString);
	}

	/**
	 * using ClientRequest and ClientResponse classes from org.jboss.resteasy.client
	 * @param httpURL
	 * @return responseString
	 * @throws IOException
	 */
	@SuppressWarnings({ "deprecation" })
	public static String testDownloadService(String httpURL) throws IOException {

		// local variables
		ClientRequest clientRequest = null;
		ClientResponse<?> clientResponse = null;
		File readSourceFile = null;
		File destinationFileLocation = null;
		FileWriter fileWriter = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;
		String qualifiedDownloadFilePath = null;

		try{
			// invoke service after setting necessary parameters
			clientRequest = new ClientRequest(httpURL);
			clientRequest.setHttpMethod(HttpMethod.GET);
			clientRequest.header("accept", "application/msword");
			clientResponse = clientRequest.get();

			// get response code
			responseCode = clientResponse.getResponseStatus().getStatusCode();
			System.out.println("Response code: " + responseCode);

			if(clientResponse.getResponseStatus().getStatusCode() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = clientResponse.getResponseStatus().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// read response and store the image file at destination
			readSourceFile = (File) clientResponse.getEntity(File.class);
			qualifiedDownloadFilePath = DOWNLOAD_FILE_LOCATION + "MyDocumentFile.docx";
			destinationFileLocation = new File(qualifiedDownloadFilePath);
			readSourceFile.renameTo(destinationFileLocation);
			fileWriter = new FileWriter(readSourceFile);
			fileWriter.flush();

			// set download SUCCES message to return
			responseString = "downloaded successfully at " + qualifiedDownloadFilePath;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			clientResponse.close();
			fileWriter.close();
			clientRequest.clear();
		}
		return responseString;
	}
}