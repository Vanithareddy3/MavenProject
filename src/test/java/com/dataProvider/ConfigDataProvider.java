package com.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider(){
		File file = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
		    pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}		
	}
	
	public String getUrl(){
		String url = pro.getProperty("url");
		return url;
	}

	public String getChromePath(){
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}

	public String getFireFoxPath(){
		String fireFoxPath = pro.getProperty("fireFoxPath");
		return fireFoxPath;
	}

}
