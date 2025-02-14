package Stepdefinitions;

import Resources.Apiresources;
import Resources.Gmapspayload;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class Stepdefinitions extends Utils {
	
	Gmapspayload gp = new Gmapspayload();
	public static RequestSpecification request;
	public static Response response;
	public static String placeid;
	
	@Given("User needs to add the Addplace Payload with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_needs_to_add_the_addplace_payload_with(String lat, String lng, String accuracy, String name, String phonenumber, String address, String types1, String types2, String website, String language) throws IOException {
		 request = given().spec(requestspecificationn()).body(gp.addplacepayload(lat,lng,accuracy,name,phonenumber,address,types1,types2,website,language));
	}
	@When("User needs to use the {string} using http {string} method")
	public void user_needs_to_use_the_using_http_method(String resources, String httpmethod) {
		Apiresources ap = Apiresources.valueOf(resources);
		 response = request.when().post(ap.getresources());

	}
	@Then("User needs to validate if response status code is {int}")
	public void user_needs_to_validate_if_response_status_code_is(Integer int1) {
		 assertEquals(response.getStatusCode(),200);
	}
	@Then("User needs to verify the response of {string} is {string}")
	public void user_needs_to_verify_the_response_of_is(String key, String value) {
		 assertEquals(getjsonparse(key, response),value);
		   placeid = getjsonparse("place_id", response);
		  System.out.println(placeid);

	}
	
	@Given("User needs to use the Getplace payload")
	public void user_needs_to_use_the_getplace_payload() throws IOException {
	   request = given().spec(requestspecificationn()).queryParam("place_id", placeid);
	}
	@When("Userr needs to use the {string} using http {string} method")
	public void userr_needs_to_use_the_using_http_method(String resources, String httpmethod) {
	    Apiresources ap =Apiresources.valueOf(resources);
	    response = request.when().get(ap.getresources());
	}
	@Then("Userr needs to validate if respons status code is {int}")
	public void userr_needs_to_validate_if_respons_status_code_is(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("Userr needs to verify if response of {string} is {string}")
	public void userr_needs_to_verify_if_response_of_is(String key, String value) {
	    assertEquals(getjsonparse(key, response),value);
	}
	
	@Given("User needs to use the deleteplace Payload")
	public void user_needs_to_use_the_deleteplace_payload() throws IOException {
	   request = given().spec(requestspecificationn()).body(gp.deleteplacepayload(placeid));
	}
	@When("Userrr needs to use the {string} using http {string} method")
	public void userrr_needs_to_use_the_using_http_method(String resources, String httpmethod) {
	    Apiresources ap = Apiresources.valueOf(resources);
	    response = request.when().delete(ap.getresources());
	}
	@Then("Userrr needs to validate if response status code is {int}")
	public void userrr_needs_to_validate_if_response_status_code_is(Integer int1) {
	   assertEquals(response.getStatusCode(),200);
	}
	@Then("Userrr needs to validate and verify if {string} is {string}")
	public void userrr_needs_to_validate_and_verify_if_is(String key, String value) {
	   assertEquals(getjsonparse(key, response),value);
	}

}
