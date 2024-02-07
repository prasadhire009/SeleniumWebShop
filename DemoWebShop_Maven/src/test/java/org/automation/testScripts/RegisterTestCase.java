package org.automation.testScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.RegisterPage;
import org.automation.genericLibrary.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTestCase extends BaseTest{
	@Test(dataProvider = "regcredentials")
	public void registerTestCase(String fn, String ln, String email, String password, String confirmPassword) throws IOException, InterruptedException {
		RegisterPage registerPage=new RegisterPage(driver);
		Random r=new Random();
		home_page.getLogoutLink().click();
		home_page.getRegisterLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/register", "Register page not displayed");
		Reporter.log("Register page displayed", true);
		
		registerPage.getMaleradioButton().click();
		registerPage.getFirstName().sendKeys(fn);
		registerPage.getLastName().sendKeys(ln);
		registerPage.getEmailTextField().sendKeys(r.nextInt(100)+email);
		registerPage.getPasswordTextField().sendKeys(password);
		registerPage.getConfirmPswTextField().sendKeys(confirmPassword);
		registerPage.getRegisterButton().click();
		
		Assert.assertEquals(registerPage.getRegisterMessage().isDisplayed(), true, "Try Again");
		Reporter.log("Successfully registered",true);
	
	}
	
	@DataProvider(name="regcredentials")
	public Object [][] dataSupply() throws EncryptedDocumentException, IOException {
		return data_Utility.getMultipleDataFromExcel("Sheet2");
	}
}
