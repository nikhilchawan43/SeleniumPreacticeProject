package logintest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
	
	//WebDriver driver;
	LoginPage loginpage;
	
	@BeforeMethod
	public void obj() {
		loginpage = new LoginPage(driver);
	}
	
	@Test(priority=1, description = "Test case for valid credentials")
	public void validCreds() {
		loginpage.login("standard_user", "secret_sauce");
		System.out.println( loginpage.homeTitle() );
	}
	
	@Test(priority=2, description = "Test case for invalid username and valid password")
	public void inValidCreds1 (){
		loginpage.login("Test_username","secret_sauce"); 
		System.out.println( loginpage.errorMsg() );
		Assert.assertEquals(loginpage.errorMsg(), "Epic sadface: Username and password do not match any user in this service");
	}
	  
	@Test(priority=3, description = "Test case for valid username and invalid password")
	public void inValidCreds2 (){ 
		loginpage.login("standard_user", "Testpass");
		System.out.println( loginpage.errorMsg() );
		Assert.assertEquals(loginpage.errorMsg(), "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test(priority=4, description = "Test case for locked user")
	public void lockUser () {
		loginpage.login("locked_out_user", "secret_sauce");
		Assert.assertEquals(loginpage.lockMsg(), "Epic sadface: Sorry, this user has been locked out.");
	}
	
	
}
