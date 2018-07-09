package com.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Factory.BrowserFactory;
import com.Factory.DataProviderFactory;
import com.pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		 driver = BrowserFactory.getBrowser("firefox");
		 driver.get(DataProviderFactory.getConfig().getUrl()); 
	}
	
	@Test
	public void testHomePage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
	    home.verifyHomePageTitle();	
	    home.clickOnSignInLink();
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
