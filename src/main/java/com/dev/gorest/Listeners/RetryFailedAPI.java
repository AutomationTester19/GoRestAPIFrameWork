package com.dev.gorest.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.gorest.BaseAPITestSuite.BaseAPITestSuite;


public class RetryFailedAPI extends BaseAPITestSuite implements IRetryAnalyzer{

	int counter=0;

	@Override
	public boolean retry(ITestResult result) {
		int limit = Integer.valueOf(getPropertyValue("limit"));
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}

}
