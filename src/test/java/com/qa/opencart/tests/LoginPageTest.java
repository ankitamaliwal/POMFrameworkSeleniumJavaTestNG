package com.qa.opencart.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.network.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.loginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {
		String actualUrl = loginPage.loginPageUrl();
		// Assert.assertEquals(actualUrl,"https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test
	public void isLoginPageHeaderExistTest() {
		Assert.assertTrue(loginPage.isHeaderExist());
	}

	@Test
	public void loginTest() throws Exception {
		accPage = loginPage.doLogin("march2024@open.com", "Selenium@12345");
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void isLogoExistTest() {
		Assert.assertTrue(loginPage.isLogoImageExist());
	}

}
