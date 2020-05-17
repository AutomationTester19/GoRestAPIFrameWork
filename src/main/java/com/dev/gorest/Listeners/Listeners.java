package com.dev.gorest.Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dev.gorest.BaseRestAPI.BaseRestAPI;

public class Listeners extends BaseRestAPI implements ITestListener {

	 Logger log = LogManager.getLogger(Listeners.class);
	 
	public void onTestStart(ITestResult result) {
		log.info("API Execution");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("API Test");

	}

	public void onTestFailure(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
				
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		log.info("API Execution Started");

	}

	public void onFinish(ITestContext context) {
		
		log.info("API Execution Completed");

	}

}
