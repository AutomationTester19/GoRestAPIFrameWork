package com.dev.gorest.BaseRestAPI;

import java.util.LinkedHashMap;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestClient extends BaseRestAPI {
	
	
	public LinkedHashMap<String, String> setqueryParametersAndHeaders(){
		
		LinkedHashMap<String,String> data = new LinkedHashMap<String, String>();
		data.put("Type", "application/json");
		data.put("token", getPropertyValue("accesstoken"));
		data.put("endurl", getPropertyValue("endPointUrl"));
		return data;
	}
	
	
	public RequestSpecification createRequest(String type){
		
		 RequestSpecification request = RestAssured.given().log().all();
		LinkedHashMap<String, String> queryMap = setqueryParametersAndHeaders();
		switch(type.toLowerCase()){
		case "json":
			request.header("Content-Type",queryMap.get("Type")).queryParam("access-token", queryMap.get("token"));
		break;
		default :
			Assert.assertNull(type);
			break;
		}
		return request;
	}

	public Response  executeGoRestAPI(RequestSpecification request, String httpMethod){
		
		LinkedHashMap<String,String> httpMap = setqueryParametersAndHeaders();
		Response response = null;
		switch(httpMethod.toLowerCase()){
		case "get":
		  response =request.get(httpMap.get("endurl"));
			break;
		}
		
		return response;
	}
	
public String getjsonValUsingJsonPath(String response, String key){
	String val = " ";
	try{
	if(key.isEmpty() || key ==null) { key = " ";  Assert.assertNull(key);}  
	   JsonPath jsonpath = new JsonPath(response);
	   val = jsonpath.getString(key);
	}catch(NullPointerException e){
		e.printStackTrace();
	}
	return val;
	}
	
}
