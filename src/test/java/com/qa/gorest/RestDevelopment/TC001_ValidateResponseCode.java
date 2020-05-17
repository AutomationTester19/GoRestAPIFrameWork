package com.qa.gorest.RestDevelopment;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dev.gorest.BaseRestAPI.GoRestClient;
import com.dev.gorest.Listeners.AllureListeners;
import com.dev.gorest.RestUtility.Utils;
import com.qa.gorest.BaseAPITestSuite.BaseAPITestSuite;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@Listeners({AllureListeners.class})
public class TC001_ValidateResponseCode  extends BaseAPITestSuite{
	
	@Test(enabled=true)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate Status Code For EndPointUrl")
	@Story("GoRest_TC001_Flow")
	public void verifyStatusCode(){
		
		GoRestClient RestClient = new GoRestClient();
		setBaseURI(getPropertyValue("baseURI"));
		RequestSpecification httpRequest = RestClient.createRequest("json");
		Response response = RestClient.executeGoRestAPI(httpRequest, "get");
		Assert.assertEquals(Utils.HTTP_RESPONSE_CODE_200	, response.statusCode());
	}
	

}
