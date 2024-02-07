package org.automation.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath = "//input[@name='removefromcart']")
	private List<WebElement> removeCheckBox;
	
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateShoppingCartButton;
	
	@FindBy(xpath = "//div[@class='order-summary-content']")
	private WebElement emptyShoppingCartMessage;
	

	public ShoppingCartPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmptyShoppingCartMessage() {
		return emptyShoppingCartMessage;
	}

	public List<WebElement> getRemoveCheckBox() {
		return removeCheckBox;
	}
	
	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}
	
	
}
