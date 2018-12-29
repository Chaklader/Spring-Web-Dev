package org.hameister.spring;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class CustomerControllerRESTassuredTest {

	private static final String CUSTOMER_ID_DOES_NOT_EXIST = "doesNotExist";

	private static final String ANY_NAME = "anyName";

	private static final String INVALID_ARGUMENT = "invalidArgument";
	
	RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	
	@BeforeClass
	public static void setupConnection() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 2001;
		RestAssured.basePath = "/spring/customers";		
	}
	
	
	@Before
	public void setup() throws Exception {
		requestSpecBuilder.setContentType(ContentType.JSON).addHeader("Accept", ContentType.JSON.getAcceptHeader());
	}
	
	private String createCustomer() {
		Response response  = given().spec(requestSpecBuilder.build()).body("").post("/");
		
		String customerLocation = response.header("location");
		
		return customerLocation.substring(customerLocation.lastIndexOf("/")+1, customerLocation.length());
	}


	@Test
	public void createACustomerShouldReturnHTTP201() throws Exception {
	
		given()
			.spec(requestSpecBuilder.build())
			.log().all()
		.when()
			.post("/")
		.then()
			.statusCode(201)
			.headers("location", containsString("/customers/"));
	}
	
	@Test
	public void updateACustomerShouldReturnHTTP204() throws Exception {
		String customerId = createCustomer();
		
		ResponseSpecBuilder noContentInResponse = new ResponseSpecBuilder();
		noContentInResponse.expectBody(is("")).expectContentType("");
		
		given()
			.spec(requestSpecBuilder.build())
			.body("{\"Name\":\""+ANY_NAME+"\"}")
			.pathParam("id", customerId)
		.when()
			.put("/{id}")
		.then()
			.statusCode(204)
			.spec(noContentInResponse.build());
	}
	
	
	@Test
	public void getACustomer() throws Exception {	
		String customerId = createCustomer();

		given()
			.pathParam("id", customerId)
		.when()
			.get("/{id}")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("id", is(customerId))
			.body("name", is(nullValue()))
			.body("created", is(nullValue()));	
	}
	
	@Test
	public void deleteACustomer() throws Exception {
		String customerId = createCustomer();
		
		given()
			.spec(requestSpecBuilder.build())
			.pathParam("id", customerId)
			.log().headers()
		.when()
			.delete("/{id}")
		.then()
			.statusCode(200);
	}
	
	

	
	@Test
	public void updateANotExistingCustomerShouldReturnHTTP404() throws Exception {

		given()
			.spec(requestSpecBuilder.build())
			.body("{\"Name\":\""+ANY_NAME+"\"}")
			.pathParam("id", CUSTOMER_ID_DOES_NOT_EXIST)
		.when()
			.put("/{id}")
		.then()
			.statusCode(404)
			.body(is("{\"reason\":\"Customer with id '"+CUSTOMER_ID_DOES_NOT_EXIST+"' not found.\"}"));
	}
	
	@Test
	public void updateACustomerWithInvalidKeyShouldReturnHTTP400() throws Exception {
		String customerId = createCustomer();
		
		given()
			.spec(requestSpecBuilder.build())
			.body("{\""+INVALID_ARGUMENT+"\":\""+ANY_NAME+"\"}")
			.pathParam("id", customerId)
		.when()
			.put("/{id}")
		.then()
			.statusCode(400)
			.body(is("{\"reason\":\"The mandatory argument 'Name' is missing in the request.\"}"));
	}
	
	
	@Test
	public void getANotExistingCustomerShouldReturnHTTP404() throws Exception {
		given()
			.spec(requestSpecBuilder.build())
			.pathParam("id", CUSTOMER_ID_DOES_NOT_EXIST)
		.when()
			.get("/{id}")
		.then()
			.statusCode(404)
			.body(is("{\"reason\":\"Customer with id '"+CUSTOMER_ID_DOES_NOT_EXIST+"' not found.\"}"));
	}
	
	
	
	@Test
	public void deleteANotExistingCustomerShouldReturnHTTP404() throws Exception {
		given()
			.spec(requestSpecBuilder.build())
			.pathParam("id", CUSTOMER_ID_DOES_NOT_EXIST)
		.when()
			.delete("/{id}")
		.then()
			.statusCode(404)
			.body(is("{\"reason\":\"Customer with id '"+CUSTOMER_ID_DOES_NOT_EXIST+"' not found.\"}"));
	}
	
	
	

	
	
	@Test
	public void getAllCustomersWithJSONPath() throws Exception {
		String customerId = createCustomer();
		Response response =
		given()
			.log().all()
		.when()
			.get("/")
		.then()
			.statusCode(200)
		.extract()
			.response();
		
		// Test with JsonPath		
		List<String> idList = from(response.body().asString()).getList("id", String.class);
		assertThat(customerId, isIn(idList));
	}
	
	
	@Test
	public void getAllCustomersWithMatcher() throws Exception {
		String customerId = createCustomer();
		
		given()
			.log().all()
		.when()
			.get("/")
		.then()
			.statusCode(200)
			.body(containsCustomerId(customerId));
	}
	
	
	private Matcher<String> containsCustomerId(String customerId) {
		final String id = customerId;
		
		return new TypeSafeMatcher<String>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("customerId="+id+" is JSON response. ({\"id\":\""+id+"\",\"name\":null,\"created\":null})");
			}

			@Override
			protected boolean matchesSafely(String jsonResponse) {
				if(jsonResponse.indexOf("\"id\":\""+id+"\"")>=0) {
					return true;
				}
				return false;
			}
		};
		
	}
}
