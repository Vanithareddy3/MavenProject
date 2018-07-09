package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//a[@class='login']") WebElement signInLink;
	
	public void  verifyHomePageTitle(){
		String title = driver.getTitle();
		Assert.assertTrue(title.equalsIgnoreCase("my store"));
	}
	
	public void clickOnSignInLink(){
		signInLink.click();
	}
}
