package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	//String baseUrl = "https://www.saucedemo.com/";
	String driverPath = "C://Users//admin//eclipse-workspace//SauceDemoAutomation//driver//chromedriver.exe";
	protected WebDriver driver;
	
	@BeforeClass
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get(baseUrl);
		
	}
	
	
	@AfterClass
	public void driverClose() {
		if (driver!=null) {
			driver.quit();
		}
		
	}
	

}
