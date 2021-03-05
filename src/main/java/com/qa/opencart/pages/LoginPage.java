package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Util;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private Util util;
	//1. By locators : OR
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login' and @type='submit']");
	private By forgotpasswordLink = By.linkText("Forgotten Password");
	
	private By registerLink = By.linkText("Register");
	
	
	//2. Constructor of the page class:
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		util = new Util(driver);
	}
	
	//3. Page Actions: features (Behavior) of the page in the form of methods
	
	
	@Step("getting the login page title....")
	public String  getLoginPageTitle(){
		
		return util.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	@Step("checking forgot pwd link is exist...")
	public boolean isForgotPasswordLinkExist(){
		System.out.println("checking forgot password link");
		return util.doIsDisplayed(forgotpasswordLink);
		
	}
	
	@Step("login with username : {0} and password : {1}")
	public AccountsPage doLogin(String un, String pwd){
		System.out.println("Login with :"+ un + "and"+ pwd);
		
		util.doSendKeys(emailId, un);
		util.doSendKeys(password, pwd);
		util.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	@Step("navigating to register page...")
	public RegisterPage navigateToRegisterPage(){
		util.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
}
