package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Util;

import io.qameta.allure.Step;

public class AccountsPage extends BasePage {
	
	private WebDriver driver;
	private Util util;
	
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemsResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");
	
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
		util = new Util(this.driver);
	}
	
	@Step("getting accounts page title...")
	public String getAccountsPageTitle(){
		return util.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
		}
	
	
	@Step("getting the header value..")
	public String getHeaderValue()
	{
		if(util.doIsDisplayed(header)){
			return util.doGetText(header);
		}
		return null;
	}
	
	@Step("getting totla number of account sections..")
	public int getAccountSectionCount(){
		
		return util.getElements(accountSectionHeaders).size();
	}

	@Step("getting account sections list from the my account page..")
	public List<String> getAccountSectionsList(){        
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accSectionList = util.getElements(accountSectionHeaders);
		
		for(WebElement e : accSectionList){
			System.out.println(e.getText());
			accountsList.add(e.getText());   
		}
		
		return accountsList;   
			
	}
	
	@Step("seraching a product with name : {0} ")
	public boolean doSearch(String productName){
	
		
		util.doSendKeys(searchText, productName);
		util.doClick(searchButton);
		
		if(util.getElements(searchItemsResult).size()>0){
			return true;
		}
		return false;
	}
	
	@Step("selecting a product with name from the results section : {0} ")
	public ProductInfoPage selectproductFromResults(String productName){
		List<WebElement> resultItemList = util.getElements(resultItems);
		System.out.println("total number of items displayed: "+resultItemList.size() );
		for(WebElement e : resultItemList){
			if(e.getText().equals(productName)){
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}
	
	public void getAccountsPageDetails(){    //some random method for a test
		System.out.println("getAccountPageDetail");
	}
	
}
