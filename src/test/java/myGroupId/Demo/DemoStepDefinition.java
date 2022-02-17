package myGroupId.Demo;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class DemoStepDefinition {
	
	
	RequestSpecification request;
	Response response;
	
	
	@Given("An Api for testing get method")
	public void an_api_for_testing_get_method() {
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";
		request=given().header("content-type","application/json");
		
		
	}

	@When("Retrieve the information from the api")
	public void retrieve_the_information_from_the_api() {
		
		System.out.println("When");
		String path="api/users?page=2";
		response=request.get(path).then().log().all().extract().response();
		
	}

	@Then("validate status  code for get method")
	public void validate_status_code_for_get_method() {
		
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
		
	}

	
	
	
	
	
	
//	RequestSpecification request;
//	Response response;
//	
//	@Given("An Api for testing get method")
//	public void an_api_for_testing_get_method() {
//	   // Write code here that turns the phrase above into concrete actions
//	System.out.println("Given");
//	RestAssured.baseURI="https://reqres.in";
//	request=given().header("content-type","application/json");
//	   //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Retrieve the information from the api")
//	public void retrieve_the_information_from_the_api() {
//	   // Write code here that turns the phrase above into concrete actions
//	  // throw new io.cucumber.java.PendingException();
//	System.out.println("When");
//	String path="api/users?page=2";
//	response=request.get(path).then().log().all().extract().response();
//
//	}
//
//	@Then("validate status  code for get method")
//	public void validate_status_code_for_get_method() {
//	   // Write code here that turns the phrase above into concrete actions
//	  // throw new io.cucumber.java.PendingException();
//	System.out.println("Then");
//	Assert.assertEquals(200, response.getStatusCode());
//	}
	}
