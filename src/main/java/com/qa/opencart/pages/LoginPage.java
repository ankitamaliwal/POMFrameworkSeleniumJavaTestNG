package com.qa.opencart.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.WaitUtil;

public class LoginPage {

private WebDriver driver;
private ElementUtil eleUtil;
private WaitUtil waitUtil;
	
	//private By locators
	private final By emailID = By.id("input-email");
	private final By password = By.id("input-password"); 
	private final By loginBtn = By.xpath("//input[@value='Login']"); 
	private final By forgotPwdLink = By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private final By header = By.xpath("//h2[text()='New Customer']");
	private final By logoImg = By.xpath("//img[@title='naveenopencart']");
	private final By subHeaders = By.xpath("//h2");
	
	//public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		waitUtil = new WaitUtil(driver);
	}

	//	public method
	public String loginPageTitle() {
		String title = waitUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_WAIT);
		System.out.println("login page title: " + title);
		return title;
	}
	
	public String loginPageUrl() {
		String url = waitUtil.waitForUrlIs(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_MEDIUM_WAIT);
		System.out.println("login page url: " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
	}
	
	public boolean isHeaderExist() {
		return eleUtil.isElementDisplayed(header);
	}
	
	public AccountsPage doLogin(String appUsername, String appPwd) throws Exception {
		System.out.println("Application Credentials: " + appUsername + " : " + appPwd);
		waitUtil.waitForElementVisible(emailID, AppConstants.DEFAULT_SHORT_WAIT).sendKeys(appUsername);
		waitUtil.waitForElementVisible(password, AppConstants.DEFAULT_SHORT_WAIT).sendKeys(appPwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}

	public boolean isLogoImageExist() {
	  return eleUtil.isElementDisplayed(logoImg);
	}
	
	public List<WebElement> loginPageSubHeaders() {
		return waitUtil.waitForElementsPresence(subHeaders, 0);
	}

}
