package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.exceptions.ElementException;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("==Element not displayed==");
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			System.out.println("==Element not displayed==");
			return false;
		}
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.err.println("Unable to click on th element with locator: " + locator);
		}
	}

	public void doSendKeys(By locator, String value) {
		if (value == null) {
			throw new ElementException("==Value cannot be null==");
		}
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.err.println("Unable to enter value: " + locator);
		}
	}

	public WebElement getElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			System.err.println("Element not found with locator: " + locator);
			return null;
		}
	}

	public List<WebElement> getElements(By locator) {
		try {
		return driver.findElements(locator);
		}catch(Exception e) {
			System.err.println("Element not found with locator: " + locator);
			return null;
		}
	}
	
	public int getElementsCount(By locator) {
		try {
			return driver.findElements(locator).size();
		} catch (Exception e) {
			System.err.println("Element not found with locator: " + locator);
			return 0;
		}
	}

	public void doClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.err.println("Unable to click on th element " + element);
		}
	}

	public List<String> getElementsTextList(By locator) {
		List<String> elementsText = new ArrayList<String>();
		List<WebElement> elements = getElements(locator);
		for(WebElement e: elements) {
			elementsText.add(e.getText());
		}
		return elementsText;
	}
}
