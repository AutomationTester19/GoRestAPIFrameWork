package com.dev.gorest.BaseRestAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BaseRestAPI {
	
	public static Properties prop;

	public static Properties configProperty(){
		
		String filePath = System.getProperty("user.dir")+"\\config\\GoRestAPI.properties";
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(new File(filePath));
			prop = new Properties();
			prop.load(fis);
		}catch(FileNotFoundException e){
				e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getPropertyValue(String key){
		String value = " ";
		try{
			Properties prop = configProperty();
			value = prop.getProperty(key);
		}catch(Exception e){  }
		
		return value;
	}

	public static void setBaseURI(String baseURI){
		
		try{
		if(baseURI.isEmpty()){ baseURI = " "; Assert.assertNull(baseURI, "Is Empty");}		 
		
		else {
			RestAssured.baseURI = baseURI;
		}
		
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
public static String getAnyStringValueUsingJsonPath(String response,String key){
		
		JsonPath jsonValue = new JsonPath(response);
		String val = jsonValue.get(key);
		try{ if(val.isEmpty() || val==null) val = " " ; } catch(Exception e){  }
		return val;
	}
}
