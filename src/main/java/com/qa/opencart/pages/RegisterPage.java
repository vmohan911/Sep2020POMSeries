package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Util;

public class RegisterPage extends BasePage{
	
	Util util;

	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword= By.id("input-confirm");
	
	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");
	
	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	
	private By accountSuccessMesg = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
		util = new Util(this.driver);
	}
	
	public boolean accountRegistration(String firstname, String lastname, String email, String telephone, String password, String subscribe){
		
		util.doSendKeys(this.firstname, firstname);
		util.doSendKeys(this.lastname, lastname);
		util.doSendKeys(this.email, email);
		util.doSendKeys(this.telephone, telephone);
		util.doSendKeys(this.password, password);
		util.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")){
			util.doClick(subscribeYes);
		}
		else{
			util.doClick(subscribeNo);
		}
		
		util.doClick(agreeCheckbox);
		util.doClick(continueButton);
		
		String text = util.doGetText(accountSuccessMesg);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MESSAGE)){
			util.doClick(logoutLink);
			util.doClick(registerLink);
			return true;
		}
		return false;
	}
	
}
