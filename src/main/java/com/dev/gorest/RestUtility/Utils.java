package com.dev.gorest.RestUtility;

import org.apache.commons.lang3.RandomStringUtils;

import com.dev.gorest.BaseRestAPI.BaseRestAPI;

public class Utils extends BaseRestAPI {

	public static final int HTTP_RESPONSE_CODE_200 = 200;
	public static final int HTTP_RESPONSE_CODE_201 = 201;
    public static final int HTTP_RESPONSE_CODE_204 =204;
    public static final int HTTP_RESPONSE_CODE_304 = 304;
	public static final int HTTP_RESPONSE_CODE_400 = 400;
    public static final int HTTP_RESPONSE_CODE_401 = 401;
    public static final int HTTP_RESPONSE_CODE_403 = 403;
	public static final int HTTP_RESPONSE_CODE_404 = 404;
    public static final int HTTP_RESPONSE_CODE_405  = 405;
    public static final int HTTP_RESPONSE_CODE_415  = 415;
    public static final int HTTP_RESPONSE_CODE_422 = 422;
    public static final int HTTP_RESPONSE_CODE_429 = 429;
    public static final int HTTP_RESPONSE_CODE_500  = 500;


	
	public static String generateRandomString(){
		
		String str = RandomStringUtils.randomAlphabetic(10);		
		return str;
	}
	
	public static String generateRandomInteger(){
		
		String val = RandomStringUtils.randomNumeric(5);
		return val;
	}
	
	public static String generateRandomAlphaNumeric(){
		
		String val = RandomStringUtils.randomAlphanumeric(6);
		return val;
	}

}
