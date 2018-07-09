package com.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Factory.BrowserFactory;
import com.Factory.DataProviderFactory;
/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;*/
import com.pages.HomePage;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Helper;

public class VerifyLoginPageWithReports1 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		 report = new ExtentReports("./Reports/LoginPageReports.html", true);
		 logger = report.startTest("Verify Login Page With Reports");
		 
		 driver = BrowserFactory.getBrowser("firefox");
		 driver.get(DataProviderFactory.getConfig().getUrl());
		 
		 logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testLoginPage() throws InterruptedException{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
	    home.verifyHomePageTitle();	
	    logger.log(LogStatus.PASS, "Home page title is verified");
	    home.clickOnSignInLink();
	    logger.log(LogStatus.INFO, "Click on Sign in link");
	    
	    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	    Thread.sleep(5000);
	    login.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	    logger.log(LogStatus.INFO, "Login to application");
	    login.verifySignOut();
	    logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "verifySignOut")));
	    logger.log(LogStatus.PASS, "Sign out is verified");
	    
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus() == ITestResult.FAILURE){
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
					
		}
		report.flush();
		BrowserFactory.closeBrowser(driver);
	}

}
