package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_SHORT_WAIT = 2;
	public static final int DEFAULT_MEDIUM_WAIT = 5;
	public static final int DEFAULT_LARGE_WAIT = 10;
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_FRACTION_URL = "route=account/account";
	
	public static final int ACCOUNT_PAGE_HEADERS_COUNT = 4;
	public static final List<String> expectedAccPageHeadersList = List.of("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	public static final List<String> expectedRightSectionLinksTextOnAccPage = List.of("My Account", "Edit Account", "Password",
																				"Address Book", "Wish List", "Order History", "Downloads", 
																				"Recurring payments", "Reward Points", "Returns", "Transactions",
																				"Newsletter", "Logout" );

}
