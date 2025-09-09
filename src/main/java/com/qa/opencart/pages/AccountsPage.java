package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.WaitUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private WaitUtil waitUtil;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(driver);
		this.waitUtil = new WaitUtil(driver);
	}
	
	private final By headers = By.cssSelector("div#content h2");
	private final By logoutLink = By.linkText("Logout");
	private final By search = By.name("search"); 
	private final By searchIcon = By.cssSelector("div#search button");
	//private final By rightLinks = By.xpath("//div[@class='list-group']/a");
	private final By rightLinks = By.xpath("//a[@class='list-group-item']");
	
	public List<String> getAccPageHeaders() {
		List<WebElement> headersList = waitUtil.waitForElementsPresence(headers, AppConstants.DEFAULT_MEDIUM_WAIT);
		System.out.println("total number of headers: " + headersList.size());
		List<String> headersValueText = new ArrayList<>();
		for(WebElement e: headersList) {
			String text = e.getText();
			headersValueText.add(text);
		}
		return headersValueText;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(waitUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_SHORT_WAIT));
	}
	
	public void performSearch(String searchKey) {
		waitUtil.waitForElementPresence(search, AppConstants.DEFAULT_SHORT_WAIT).sendKeys(searchKey);;
		eleUtil.doClick(searchIcon);	
	}
	
	public String accountPageTitle() {
		String title = waitUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_SHORT_WAIT);
		return title;
	}

	public String accountPageUrl() {
		String url = waitUtil.waitForUrlIs(AppConstants.ACCOUNT_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_WAIT);
		return url;
	}
	
	public List<String> accountPageRightSectionLinksText() {
		List<String> linksText = eleUtil.getElementsTextList(rightLinks);
		System.out.println(linksText);
		return linksText;
	}
	
	public SearchResultsPage searchResultsPage(String searchKey) {
		waitUtil.waitForElementPresence(search, AppConstants.DEFAULT_SHORT_WAIT).sendKeys(searchKey);;
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
		
	}
}
	
