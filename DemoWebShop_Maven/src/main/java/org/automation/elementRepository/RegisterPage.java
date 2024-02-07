package org.automation.elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	@FindBy(id = "gender-male")
	private WebElement maleradioButton;
	
	@FindBy(id = "gender-female")
	private WebElement femaleradioButton;
	
	public RegisterPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMaleradioButton() {
		return maleradioButton;
	}

	public WebElement getFemaleradioButton() {
		return femaleradioButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPswTextField() {
		return confirmPswTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getRegisterMessage() {
		return registerMessage;
	}

	@FindBy(id ="FirstName" )
	private WebElement firstName;
	
	@FindBy(id = "LastName")
	private WebElement lastName;
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPswTextField;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']" )
	private WebElement registerMessage;
	
	
		
	
}
