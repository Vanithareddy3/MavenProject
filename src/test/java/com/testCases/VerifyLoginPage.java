package com.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Factory.BrowserFactory;
import com.Factory.DataProviderFactory;
import com.pages.HomePage;
import com.pages.LoginPage;

public class VerifyLoginPage {

	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		 driver = BrowserFactory.getBrowser("firefox");
		 driver.get(DataProviderFactory.getConfig().getUrl()); 
	}
	
	@Test
	public void testLoginPage(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
	    home.verifyHomePageTitle();	
	    home.clickOnSignInLink();
	    
	    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	    login.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	    login.verifySignOut();
	    
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
