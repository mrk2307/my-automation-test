package com.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	public class ExtentReportListener implements ITestListener {
	    private ExtentReports extent;
	    private ExtentTest test;

	    public void onStart(ITestContext context) {
	        // Initialize ExtentReports
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
	        htmlReporter.config().setDocumentTitle("Automation Test Report");
	        htmlReporter.config().setReportName("Test Execution Report");
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User", "Automation Tester");
	    }

	    public void onTestStart(ITestResult result) {
	        // Create a test node for each test case
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        // Log success
	        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	    }

//	    public void onTestFailure(ITestResult result) {
//	        // Log failure and capture the exception
//	        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
//	        test.log(Status.FAIL, result.getThrowable());
//	    }

	    public void onTestSkipped(ITestResult result) {
	        // Log skipped tests
	        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	        test.log(Status.SKIP, result.getThrowable());
	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Optional: Log for partial success
	    }
	    
	    public void onTestFailure(ITestResult result)
	    {
	        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, result.getThrowable());

	        // Add screenshot (replace with your screenshot utility)
	       // String screenshotPath = System.getProperty("user.dir") + "/FailedScreenshots/error.png";
	        String screenshotPath = "C:\\Users\\mrk40\\screenshot\\fail.png"; // Replace with dynamic screenshot path
	        test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
	    }

	    public void onFinish(ITestContext context) {
	        // Write the report to the output file
	        if (extent != null) {
	            extent.flush();
	        }
	    }
	}
	

