package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPageHubApp extends TestBase {

	@FindBy(xpath="//input[@placeholder='E-mail address']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement signUpLink;
	
	
	//1.b: Constructor of page class and initialize elements with driver
	public LoginPageHubApp(){
	
		PageFactory.initElements(driver, this);
	}
	
	//2. Page methods - Actions:
	@Step("getting login page title	step..")
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	@Step("varifying sing up link is displayed step...")
	public boolean VerifySignUpLink(){
		return signUpLink.isDisplayed();
	}
	

	
	@Step("login with username: {0} and password: {1} step...")
	public HomePageHubApp login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		    	return new HomePageHubApp ();
	}

	
	
	
	
}
