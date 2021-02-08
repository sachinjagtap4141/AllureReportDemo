package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePageHubApp;
import com.qa.pages.LoginPageHubApp;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
//@Listeners({TestAllureReportListener.class})
public class LoginPageHubAppTest extends TestBase {
	LoginPageHubApp loginPage;
	HomePageHubApp homePage;
	
	public LoginPageHubAppTest(){
		super();
	}
	
	@BeforeMethod //this method will be executed before every @test method
	public void setUp(){
		initialization();
		loginPage = new LoginPageHubApp();
	}
	
	@Test(priority=1, description="varify logion page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case Description: variy login page title test on login page")
	@Story("Story name: To check login page title")
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("the login page title is: "+ title);
		Assert.assertEquals(title, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2, description="varifying sign up link test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description: variy sign up link test on login page")
	@Story("Story name: To check sing up link")
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.VerifySignUpLink());
	}
	
	@Test(priority=3, description="login into app test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Description: variy login into application with correct credentials ")
	@Story("Story name: To check login functionality")
	public void loginCorrectCredentialsTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	} 	
	
	
	@AfterMethod //--this method will be executed after every test method
	public void tearDown(){
		driver.quit();
	}
	
	

	
	
}
