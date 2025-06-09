package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private	WebDriverWait wait;
	
	//locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//PageFactory.initElements(driver, this);
	}
	
	//locatorswithactions
	public String homeTitle() {
		return driver.getTitle();
	}
	
	public String errorMsg() {
		return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	}
	
	public String lockMsg() {
		return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		
	}
	
	//actionmethods
	public void login(String user, String pass) {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}

}
