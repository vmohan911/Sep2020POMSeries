package com.qa.opencart.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp(){
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void ProductInfoPageTitleTest_iMac(){
        accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectproductFromResults("iMac");
		
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}

	@Test
	public void verifyProductInfoTest_MacBook(){
		
		productInfoPage.toClear();
		String productName = "MacBook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectproductFromResults("MacBook Pro");
		
		Assert.assertTrue(productInfoPage.getProductImages()==4);
		
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		//the map we are getting is-
		//{Brand=Apple, Availability=In Stock, price=$2,000.00, name=MacBook Pro, Product Code=Product 18, Reward Points=800, exTaxPrice=$2,000.00}
		Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");     
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
			
	}
	
	@Test
	public void verifyProductInfoTest_iMac(){
		
		productInfoPage.toClear();
		String productName = "iMac";
		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectproductFromResults("iMac");
		
		Assert.assertTrue(productInfoPage.getProductImages()==3);
		
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		//the map we are getting is-
		//{Brand=Apple, Availability=In Stock, price=$2,000.00, name=MacBook Pro, Product Code=Product 18, Reward Points=800, exTaxPrice=$2,000.00}
		Assert.assertEquals(productInfoMap.get("name"), "iMac");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("price"), "$100.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		
		
		
		
	}
}
