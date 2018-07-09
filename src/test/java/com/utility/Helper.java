package com.utility;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName){
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\a631020\\eclipse-workspace\\com.DemoMavenSelenium\\Screenshots\\" + screenshotName + System.currentTimeMillis() + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		}
		catch (IOException e) {
			System.out.println("Failed to capture screenshot" + e.getMessage());
		}
		return destination;
	}

}
