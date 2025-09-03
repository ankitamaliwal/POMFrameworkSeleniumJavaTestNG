package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.FrameworkException;

public class DriverFactory {
	//used to initialize the driver or to design the driver
	public WebDriver driver;
	
	public WebDriver initDriver(String browserName){
		System.out.println("Browser name: " + browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println(AppError.INVALID_BROWSER_MSG + " : " + browserName);
			throw new FrameworkException("===INVALID BROWSER===");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		return driver;
	}

}
