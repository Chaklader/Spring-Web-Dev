package test.apache.cxf.spring.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

public class TestPlayerService {

	/**
	 * main method to invoke test method
	 * @param args
	 */
	public static void main(String[] args) {

		/*String requestURL = "http://localhost:8080/ApacheCXF-XML-JSON-IO/services/playerservice/addplayer";
		String httpMethod = HttpMethod.POST;
		String contentType = MediaType.APPLICATION_XML;
		String accept = MediaType.APPLICATION_FORM_URLENCODED;
		String requestString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+				"<PlayerType xmlns=\"http://benchresources.in/cdm/Player\">"
				+					"<playerId>183</playerId>"
				+					"<name>Courtney Walsh</name>"
				+					"<age>52</age>"
				+					"<matches>132</matches>"
				+ 				"</PlayerType>";

		String[] requestParams = {requestURL, httpMethod, contentType, accept, requestString};*/


		String requestURL = "http://localhost:8080/ApacheCXF-Spring-Hibernate/services/playerservice/getplayer/10";
		String httpMethod = HttpMethod.GET;
		String contentType = MediaType.APPLICATION_FORM_URLENCODED;
		String accept = MediaType.APPLICATION_JSON;
		String requestString =  "{" 
				+  		"\"playerId\": 222," 
				+  		"\"name\": \"Ridley Jacobs\","
				+  		"\"age\": 47,"
				+  		"\"matches\": 65 "
				+  	"}";

		String[] requestParams = {requestURL, httpMethod, contentType, accept, requestString};

		String responseFromService = testPlayerService(requestParams);
		System.out.println("Response String: " + responseFromService);
	}

	/**
	 * This method uses HttpURLConnection to invoke exposed Restful web service and returns the response string to the calling client
	 * @param requestParams
	 * @return
	 */
	public static String testPlayerService(String[] requestParams) {

		// local variables
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		OutputStreamWriter outputStreamWriter = null;
		String responseMessageFromServer = null;
		String responseXML = null; 

		try {   
			url = new URL(requestParams[0]);
			httpURLConnection = (HttpURLConnection) url.openConnection();   
			httpURLConnection.setRequestMethod(requestParams[1]);   
			httpURLConnection.setRequestProperty("Content-Type", requestParams[2]);
			httpURLConnection.setRequestProperty("Accept", requestParams[3]);
			httpURLConnection.setDoOutput(true);

			/*outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
			outputStreamWriter.write(requestParams[4]);
			outputStreamWriter.flush();*/

			System.out.println("Response code: " + httpURLConnection.getResponseCode());

			if (httpURLConnection.getResponseCode() == 200) {

				responseMessageFromServer = httpURLConnection.getResponseMessage();
				System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);
				responseXML = getResponseXML(httpURLConnection);
			} 
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		finally{
			httpURLConnection.disconnect();
		}
		return responseXML; 
	}

	/**
	 * This method is used to get response XML from the HTTP GET Request created for Authorization WireKey
	 * @param httpURLConnection
	 * @return stringBuffer.toString()
	 * @throws IOException
	 */
	private static String getResponseXML(HttpURLConnection httpURLConnection) throws IOException{

		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String readSingleLine = null;

		try{
			// read the response stream AND buffer the result into a StringBuffer
			inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// reading the XML response content line BY line 
			while ((readSingleLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(readSingleLine);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// finally close all operations
			bufferedReader.close();
			httpURLConnection.disconnect();
		}
		return stringBuffer.toString();
	}
}