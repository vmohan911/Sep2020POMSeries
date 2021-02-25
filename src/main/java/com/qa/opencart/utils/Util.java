package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.base.BasePage;

public class Util {
	
	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	public Util(WebDriver driver){
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);

	}
	/**
	 * This method is to create the web element
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		WebElement element = driver.findElement(locator);
		if(BasePage.highlight.equals("true")){
			jsUtil.flash(element);
		}
		return element;
	}
	
	public void clearing(By locator){
		driver.findElement(locator).clear();
	}
	
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	public void visibilityOfAllElements(List<WebElement> elements, int timeOut ){
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
	/**
	 * This is for title presence explicitly wait
	 */
	
	public String waitForTitlePresent(String title, int timeOut){
		WebDriverWait wait1 = new WebDriverWait(driver,timeOut); 
		wait1.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	
	
	
	/**
	 * method for explicitly wait
	 */
	public WebElement waitForElementPresent(By locator, int timeOut){
		
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
		
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut){
		
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
		
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
		
	}
	
	public WebElement waitForElementVisibilityLocated(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator);
		
	}
	
	public String waitForUrl(String url, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
		
	}
	
	public boolean waitForAlertTobePresent(int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
		
	}
	
	public void clickWhenReady(By locator,int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
		
	}
	
	
	/**
	 * This method is to click on element
	 * @param locator
	 */
	
	public void doClick(By locator){
		try{
		getElement(locator).click();
		}catch(Exception e){
			System.out.println("Some exceptions occured  while creating the element");
			System.out.println(e.getMessage());
		}
			
		
		
	}
	/**
	 * This method is to pass the values
	 * @param locator
	 * @param value
	 */
	
	public void doSendKeys(By locator, String value){
		try{
		getElement(locator).sendKeys(value);
		}catch(Exception e){
			System.out.println("Some exceptions occured  while creating the element");
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionsSendKey(By locator, String value){
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element, value).perform();
		
				}
	
	public void doActionsClick(By locator){
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.click(element).perform();
	}

}
