package org.automation.genericLibrary;


import java.io.IOException;
	import java.time.Duration;

	import org.automation.elementRepository.HomePage;
	import org.automation.elementRepository.LoginPage;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;

public class BaseTest {
		public WebDriver driver;
		public DataUtility data_Utility = new DataUtility();
		public HomePage home_page ;
		public CommonUtility common_Utility = new CommonUtility() ;
	 static WebDriver listenerDriver;
		
		@Parameters("Browser")
		@BeforeClass(alwaysRun = true )
		public void launchBrowser(@Optional("Chrome") String broswerName) throws IOException
		{
			if(broswerName.equals("Chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(broswerName.equals("Edge")) 
			{
				driver = new EdgeDriver();
			}
			else 
				System.out.println("Select valid browser");
			listenerDriver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(data_Utility.getDataFromProperties("url"));
		}
		@BeforeMethod(alwaysRun = true )
		public void performLogin() throws IOException
		{
			home_page = new HomePage(driver);
			home_page.getLoginLink().click();

			LoginPage lg_pg = new LoginPage(driver);
			lg_pg.getEmailTextField().sendKeys(data_Utility.getDataFromProperties("email"));
			lg_pg.getPasswordTextField().sendKeys(data_Utility.getDataFromProperties("pwd"));
			lg_pg.getLoginButton().click();
		}

		@AfterMethod(alwaysRun = true )
		public void performLogout()
		{
			home_page.getLogoutLink().click();
		}

		@AfterClass(alwaysRun = true )
		public void closeBrowser()
		{
			driver.quit();
		}
}







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

