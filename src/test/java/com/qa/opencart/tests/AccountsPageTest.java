package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("EPIC-200: Design accounts page")
@Story("US-201: designing the accounts page with title, header, accont sections and product results...")
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void AccountsPageSetup(){
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("accounts page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyAccountsPageTitleTest(){
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("accounts page title is : "+ title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Description("accounts page header test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyAccountsPageHeaderTest(){
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("Accounts Page header is :"+ headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Description("accounts page sections count test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void verifyMyAccountSectionsCountTest(){
		Assert.assertTrue(accountsPage.getAccountSectionCount()==Constants.ACCOUNTS_SECTIONS);		
		
	}
	
	@Description("accounts page sections list test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=4)
	public void verifyMyAccountSectionsListTest(){
		
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}
	
	@Description("accounts page search test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=5)
	public void searchTest(){
		Assert.assertTrue(accountsPage.doSearch("iMac"));
		}
}
