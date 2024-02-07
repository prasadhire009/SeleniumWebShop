package org.automation.elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(partialLinkText = "Log")
	private WebElement loginLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]")
	private WebElement digitalDownloads;
	
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishlistLink;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Books')]")
	private WebElement booksLink;
	
	

	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBooksLink() {
		return booksLink;
	}
	
	public WebElement getWishlistLink() {
		return wishlistLink;
	}
	
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
	public WebElement getDigitalDownloads() {
		return digitalDownloads;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}


	
	

	
}
