package logintest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.Inventory;
import pages.LoginPage;
import utils.BaseTest;

public class InventoryTest extends BaseTest {
	
	Inventory inventory;
	LoginPage loginpage;
	
	String baseUrl = "https://www.saucedemo.com/";
	
	
	@BeforeMethod
	public void setUpInv() throws InterruptedException {
		driver.get(baseUrl);
		inventory = new Inventory(driver);
		loginpage = new LoginPage(driver);
		Thread.sleep(5000);
		loginpage.login("standard_user", "secret_sauce");
		Thread.sleep(5000);
	}
	
	@Test(priority = 1, description = "Test case for count of products")
	public void countProd() throws InterruptedException {
		Assert.assertEquals(6, inventory.prodCount());
		System.out.println(inventory.prodCount());
		//inventory.alertBox();
	}
	
	@Test(priority = 2, description = "Test case for remove button verification")
	public void addClick() {
		//inventory.alertBox();
		inventory.addProdClick();
		Assert.assertEquals(inventory.remProdText(), "Remove");
		Assert.assertEquals(inventory.cartBadge(), "1");
	}
	
	@Test(priority = 3, description = "Test case for add to cart button verification")
	public void remClick() {
		inventory.addProdClick();
		inventory.remProdClick();
		Assert.assertEquals(inventory.addProdText(), "Add to cart");
	}
	
	
}
