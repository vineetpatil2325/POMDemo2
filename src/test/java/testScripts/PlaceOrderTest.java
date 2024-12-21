package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.ChkoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
    WebDriver driver;
    LoginPage loginpage;
    ProductListPage listPage;
    CartPage cartPage;
    ChkoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        TestBase.initDriver();
        driver = TestBase.GetDriver();
        loginpage = new LoginPage(driver);
        listPage = new ProductListPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new ChkoutPage(driver);
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
	
	@Test(priority = 3)
	public void checkoutTest() {
		cartPage.checkoutItems();
		checkoutPage.provideDeatils("Test","User", "223434");
		checkoutPage.checkoutOrder();
		Assert.assertTrue(checkoutPage.isOrderSuccess());
		
		
	}
}
