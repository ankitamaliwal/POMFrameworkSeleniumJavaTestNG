package com.qa.opencart.utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	private WebDriver driver;

	public WaitUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String waitForTitleIs(String expectedTitleValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.titleIs(expectedTitleValue));
		} catch(Exception e) {
			System.out.println("Expected title value: " + expectedTitleValue + " is not present");
		}

		return driver.getTitle();
	}
	
	public String waitForUrlIs(String fractionUrlValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.urlContains(fractionUrlValue));
		} catch(Exception e) {
			System.out.println("Url fraction value: " + fractionUrlValue + " is not present");
		}

		return driver.getCurrentUrl();
	}
	
	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Element not visible: " + locator);
			return null;
		}
	}
	
	public List<WebElement> waitForElementsPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}catch(Exception e) {
			System.out.println("Elements not present: " + locator);
			return null;
		}
	}

	public WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Element not present: " + locator);
			return null;
		}
	}
}
