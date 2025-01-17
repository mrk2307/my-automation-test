package com.example.javaTraining;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SampleTest {

//	public SampleTest() {
//		// TODO Auto-generated constructor stub
//	}

	private WebDriver driver;

	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test //(priority=1)
	public void openGoogle()
	{
		driver.get("https://www.google.com");
		System.out.println("page title is:" + driver.getTitle());
		  System.out.println("Google opened on Thread: " + Thread.currentThread().getId());
		  
	
		 
	}
	
    @Test
    public void FirefoxTest() {	 
        //Initializing the firefox driver (Gecko)
    driver = new FirefoxDriver();	  
    driver.get("http://www.google.com"); 

    System.out.println("page title is:" + driver.getTitle());
	System.out.println("Google opened on Thread: " + Thread.currentThread().getId());

     }
	
	@Test //(priority=2)
	public void openGoogle2()
	{
		 driver.get("https://www.google.com");
		 System.out.println("page title is:" + driver.getTitle());
		 System.out.println("Google opened on Thread: " + Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}


}

