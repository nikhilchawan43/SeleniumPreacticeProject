package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventory {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//locators
	private By prodItems = By.xpath("//div[@class='inventory_item']");
	private By adButton = By.xpath("//button[contains(text(),'Add to cart')][1]");
	private By remBtn = By.xpath("//button[contains(text(),'Remove')]");
	private By cartCnt = By.xpath("//div/a/span[contains(text(),'1')]");
	
	
	public Inventory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//PageFactory.initElements(driver, this);
	}
	
	public int prodCount() {
		List<WebElement> prods = driver.findElements(prodItems);
		return prods.size();
	}
	
	public void addProdClick() {
		driver.findElement(adButton).click();
	}
	
	public void remProdClick() {
		driver.findElement(remBtn).click();
	}
	
	public String remProdText() {
		return driver.findElement(remBtn).getText();
	}
	
	public String addProdText() {
		return driver.findElement(adButton).getText();
	}
	
	public String cartBadge() {
		return driver.findElement(cartCnt).getText();
	}
	
	public void alertBox() {
		driver.switchTo().alert().accept();
	}

}
