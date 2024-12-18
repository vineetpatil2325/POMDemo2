package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement itemOne;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement itemTwo;
	
	@FindBy(id="shopping_cart_container")
	WebElement cartIcon;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement productsTitle;
	
	//Actions
	//add to Cart
	//View Cart
	
	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void addtoCart() {
		itemOne.click();
		itemTwo.click();
		
	}
	
	public void viewCart() {
		cartIcon.click();
		
	}
	
	public boolean isOnProducts() {
		return productsTitle.isDisplayed();
	}
	
}
