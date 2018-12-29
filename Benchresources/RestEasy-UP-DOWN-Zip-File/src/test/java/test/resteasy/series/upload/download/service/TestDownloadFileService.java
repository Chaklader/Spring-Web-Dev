package test.resteasy.series.upload.download.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TestDownloadFileService {

	public static final String DOWNLOAD_FILE_LOCATION = "D:/Demo/test/";

	public static void main(String []args) throws IOException {

		String httpURL = "http://localhost:9090/RestEasy-UP-DOWN-Zip-File/resteasy/fileservice/download/zip";
		String responseString = testDownloadService(httpURL);
		System.out.println("responseString : " + responseString);
	}

	/**
	 * using Client, WebTarget from core JAX-RS classes javax.ws.rs.client
	 * @param url
	 */
	public static String testDownloadService(String httpURL) throws IOException {

		// local variables
		Client client = null;
		WebTarget webTarget = null;
		Builder builder = null;
		Response response = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;
		String qualifiedDownloadFilePath = null;

		try {
			// invoke service after setting necessary parameters
			client = ClientBuilder.newClient();
			webTarget = client.target(httpURL);
			client.property("accept", "application/zip");
			builder = webTarget.request();
			response = builder.get();

			// get response code
			responseCode = response.getStatus();
			System.out.println("Response code: " + responseCode);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// read response string
			inputStream = response.readEntity(InputStream.class);
			qualifiedDownloadFilePath = DOWNLOAD_FILE_LOCATION + "MyZipFile.zip";
			outputStream = new FileOutputStream(qualifiedDownloadFilePath);
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			// set download SUCCES message to return
			responseString = "downloaded successfully at " + qualifiedDownloadFilePath;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			outputStream.close();
			client.close();
		}
		return responseString;
	}
}