package com.dev.frontend.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyRestClient {
    public static String BASEURL="http://localhost:8080/";

    public static JSONObject getRequest(String urlString){
        System.out.println("*************GET REQUEST");
        System.out.println("*************URL: "+urlString);
        String response="";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String responseLine="";
            while ((responseLine = br.readLine()) != null) {
                response+=responseLine;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        } catch (IOException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        }
        finally {
            System.out.println("*****************GET RESPONSE "+response);
            return processResultAsJson(response);
        }

    }

    public static JSONArray getRequestForArray(String urlString){
        System.out.println("*************GET REQUEST ARRAY");
        System.out.println("*************URL: "+urlString);
        String response="";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("ERROR!!!!!!! Failed : HTTP error code : "+ conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String responseLine="";
            while ((responseLine = br.readLine()) != null) {
                response+=responseLine;
            }
            conn.disconnect();

        } catch (MalformedURLException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        } catch (IOException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        }
        finally {
            System.out.println("*****************GET RESPONSE "+response);
            return processResultAsJsonArray(response);
        }

    }

    public static JSONObject postRequest(String urlString, String body) {
        System.out.println("**********POST REQUEST");
        System.out.println("**********URL: "+urlString);
        System.out.println("**********body: "+body);
        String response="";
        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String responseLine="";
            while ((responseLine = br.readLine()) != null) {
                System.out.println("RESPONSELINE: "+responseLine);
                response+=responseLine;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            response="{\"error\":\""+e.getMessage()+"\"}";
            e.printStackTrace();

        } catch (IOException e) {
            response="{\"error\":\""+e.getMessage()+"\"}";
            e.printStackTrace();

        }
        finally {
            System.out.println("*****************POST RESPONSE "+response);
            return processResultAsJson(response);
        }
    }

    public static JSONObject deleteRequest(String urlString){
        System.out.println("*************DELETE REQUEST");
        System.out.println("*************URL: "+urlString);
        String response="";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String responseLine="";
            while ((responseLine = br.readLine()) != null) {
                response+=responseLine;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        } catch (IOException e) {

            response="{\"error\":\""+e.getMessage()+"\"}";

        }
        finally {
            System.out.println("*****************DELETE RESPONSE "+response);
            return processResultAsJson(response);
        }

    }

    static JSONObject processResultAsJson(String response){
        JSONObject jsonResponse=null;
        try {
            if(!response.equals("")){
                jsonResponse=(JSONObject)new JSONParser().parse(response);
            }
            else{
                jsonResponse=(JSONObject)new JSONParser().parse("{\"error\":\"Unexpected error in HttpClient\"}");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    static JSONArray processResultAsJsonArray(String response){
        JSONArray jsonResponse=null;
        try {
            if(!response.equals("")){
                jsonResponse=(JSONArray)new JSONParser().parse(response);
            }
            else{
                jsonResponse=(JSONArray)new JSONParser().parse("[{\"error\":\"Unexpected error in HttpClient\"}]");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
