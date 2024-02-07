package org.automation.testScripts;

import org.automation.elementRepository.BooksPage;
import org.automation.elementRepository.FictionEXPage;
import org.automation.elementRepository.WishlistPage;
import org.automation.genericLibrary.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WishlistTestCase extends BaseTest{

	@Test
	public void addToWishlistTestCase() {
		
		home_page.getBooksLink().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "books page not displayed");
		Reporter.log("Books page displayed", true);
		
		BooksPage booksPage=new BooksPage(driver);
		booksPage.getFictionEXBook().click();
		
		
		FictionEXPage exPage=new FictionEXPage(driver);
		
		Assert.assertEquals("Fiction EX" , exPage.getProductName().getText(), "Product not added to wishlist");
		Reporter.log("Product added to wishlist");
		
		exPage.getAddToWishlistButton().click();
		
		Assert.assertEquals(exPage.getAddedToWishlistMessage().isDisplayed(), true, "Product not added");
		Reporter.log("Product added successfully",true);
		
		home_page.getWishlistLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/wishlist", "wishlist page not displayed");
		Reporter.log("Wishlist page is displayed" , true);
		
		
		WishlistPage wishpage=new WishlistPage(driver);
		
		wishpage.getRemoveFromWishlistCheckbox().click();
		wishpage.getUpdateWishlist().click();
		
		Assert.assertEquals(wishpage.getEmptyWishlistMessage().isDisplayed(), true, "Product not removed from wishlist");
		Reporter.log("Product removed from wishlist",true);
		
	}
	
}
