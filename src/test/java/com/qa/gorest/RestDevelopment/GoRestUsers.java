package com.qa.gorest.RestDevelopment;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dev.gorest.BaseRestAPI.GoRestClient;
import com.dev.gorest.RestUtility.Utils;
import com.qa.gorest.BaseAPITestSuite.BaseAPITestSuite;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.dev.gorest.Listeners.Listeners.class)
public class GoRestUsers extends BaseAPITestSuite {

	private RequestSpecification request;
	private Response response;
	
	
	
	@Test(description = "Validate the status code",enabled=false)
	public void verifyValidResponseCode(){
		
		GoRestClient RestClient = new GoRestClient();
		setBaseURI(getPropertyValue("baseURI"));
		 request = RestClient.createRequest("json");
		 response =RestClient.executeGoRestAPI(request,"get");
		 response.prettyPrint();
		 Assert.assertEquals(200, Utils.HTTP_RESPONSE_CODE_200);
		
	}
	
	@Test(description = "Validate Messgae is displayed and not null",enabled=false)
	public void verifyMessageIsNotNull(){
		
		GoRestClient RestClient = new GoRestClient();
		setBaseURI(getPropertyValue("baseURI"));
		 request = RestClient.createRequest("json");
		 response =RestClient.executeGoRestAPI(request,"get");
		String res =  response.asString();
		String message = RestClient.getjsonValUsingJsonPath(res, "_meta.message");
		Assert.assertEquals(message, "OK. Everything worked as expected.");
		
	}
}
