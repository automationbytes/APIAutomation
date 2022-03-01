package StepDefn;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class RestApisteps {
	public Response response;
	@Before
	public void testStart() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
	}
	
	
	@Given("the user checks baseURI is working")
	public void the_user_checks_base_uri_is_working() {
	//	
		ValidatableResponse r = RestAssured.given().get().then();
		//r.statusCode(200);
	}
	@Then("the user perform get request")
	public void the_user_perform_get_request() {
		  response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .param("postId", "2")
	                .when()
	                .get("/comments")
	                .then()
	                .extract().response();
		  System.out.println(response.asPrettyString());
	}
	@Then("the user verifies the status code")
	public void the_user_verifies_the_status_code() {
		
		Assert.assertEquals(200, response.getStatusCode());
	}

}
