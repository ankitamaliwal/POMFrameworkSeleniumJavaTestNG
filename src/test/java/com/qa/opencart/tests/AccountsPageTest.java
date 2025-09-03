package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetup() throws Exception {
		accPage = loginPage.doLogin("march2024@open.com", "Selenium@12345");
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist()); 
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.expectedAccPageHeadersList);
		Assert.assertEquals(actualHeadersList.size(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.accountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accPageUrlTest() {
		Assert.assertTrue(accPage.accountPageUrl().contains(AppConstants.ACCOUNT_PAGE_FRACTION_URL));
	}
	
	@Test
	public void accPageRightSectionLinksTextTest() {
		Assert.assertEquals(accPage.accountPageRightSectionLinksText(), AppConstants.expectedRightSectionLinksTextOnAccPage);
	}
	
}
