package com.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	public static WebDriver getBrowser(String browserName){
		if(browserName.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.firefox.marionette",DataProviderFactory.getConfig().getFireFoxPath());
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome")){
			ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		else{
			System.out.println("No Browser Found.");
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver){
		ldriver.quit();
	}

}
