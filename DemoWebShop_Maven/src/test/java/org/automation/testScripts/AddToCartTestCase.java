package org.automation.testScripts;

import java.util.List;

import org.automation.elementRepository.DigitalDownloadPage;
import org.automation.elementRepository.ShoppingCartPage;
import org.automation.genericLibrary.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.automation.genericLibrary.ListenersImplementation.class)
public class AddToCartTestCase extends BaseTest {

	@Test
	public void addToCartTestCase() throws InterruptedException {
		int count=0;
		home_page.getDigitalDownloads().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Digital downloads", "Digital page not displayed");
		Reporter.log("Digital download page is displayed", true);
		
		DigitalDownloadPage digitalDownloadPage=new DigitalDownloadPage(driver);
		List<WebElement> add = digitalDownloadPage.getAddToCartButton();
		for (WebElement webElement : add) {
			webElement.click();
			Thread.sleep(1000);
			count++;
			Assert.assertEquals(digitalDownloadPage.getAddToCartMessage().isDisplayed(), true, count+"Product not added");
			Reporter.log(count+" "+"product added to cart", true);
			
		}
		
		Assert.assertEquals(count, 3, "Products are not added ");
		Reporter.log("Products are successfully added to cart", true);
		
		home_page.getShoppingCartLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart", "Shooping cart page not displayed");
		Reporter.log("Shopping cart page is displayed",true);
		
		ShoppingCartPage cartPage=new ShoppingCartPage(driver);
		List<WebElement> remove = cartPage.getRemoveCheckBox();
		for (WebElement webElement : remove) {
			webElement.click();
		}
		
		cartPage.getUpdateShoppingCartButton().click();
		
		Assert.assertEquals(cartPage.getEmptyShoppingCartMessage().isDisplayed(), true, "message not displayed");
		Reporter.log("All the products are removed successfully",true);
		
	}
	
}
