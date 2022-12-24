package com.aiite.jenkins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetUp {
	
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void browserSelection() throws IOException {
		
		prop=new Properties();
		FileInputStream file=new FileInputStream("input.properties");
		prop.load(file);
		//prop.getProperty(browser);
		if(System.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(System.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(System.getProperty("browser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.get("https://www.vectonemobile.co.uk/");
	}
	@AfterMethod	
	public void browserClose() {
		driver.quit();
	}

}
