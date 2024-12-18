package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	WebDriver driver;
	LoginPage loginpage;
	ProductListPage listPage;
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver=TestBase.GetDriver();
		loginpage=new LoginPage(driver);
		listPage = new ProductListPage(driver);
	}
	
	@BeforeTest
	public void setUp() {
		TestBase.openUrl("https://www.saucedemo.com/");
		
	}
	
	@Test(priority = 1)
	public void loginTest() {
		loginpage.validLogin("standard_user", "secret_sauce");
	}
	
	@Test(priority = 2)
	public void addItemTest() {
		boolean isOnProductPage = listPage.isOnProducts();
		Assert.assertTrue(isOnProductPage);
		listPage.addtoCart();
		listPage.viewCart();
	}
}
