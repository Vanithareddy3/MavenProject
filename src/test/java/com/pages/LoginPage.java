package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(id = "email") WebElement userName;
	@FindBy(id = "passwd") WebElement pwd;
	@FindBy(id = "SubmitLogin") WebElement signIn;
	@FindBy(xpath = ".//a[@class='logout']") WebElement signOut;
	
	public void loginToApplication(String excelUserName, String excelPwd){
		userName.sendKeys(excelUserName);
		pwd.sendKeys(excelPwd);
		signIn.click();
	}
	
	public void verifySignOut(){
		String text = signOut.getText();
		Assert.assertEquals(text, "Sign out", "sign out link not verified properly.");
	}
	
}
