package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class CommonUtility {
	public int getRandomNumber() {
		Random r=new Random();
		return r.nextInt(2000);
	}

	public void toTakeScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshots/"+name+".png");
		FileHandler.copy(src, trg);
	}
	
	public void selectDropdownByIndex(WebElement element, int indexNum) {
	    Select select=new Select(element);
		select.selectByIndex(indexNum);
	}
	
	public void selectDropdownByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void selectDropdownByVisibleText(WebElement element, String text) {
		
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void scrollByJavaExecutorByXY(WebDriver driver,int x, int y) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("scrollBy("+x+","+y+");");
	}
	
	public void scrollByJavaScriptExecutorByArguments(WebDriver driver, WebElement target, boolean value) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView("+value+");", target);
	}
	
	public void scrollByAmountByAction(WebDriver driver, int x, int y) {
		Actions actions=new Actions(driver);
		actions.scrollByAmount(x,y).perform();
	}
	
	public void scrollByOriginByAction(WebDriver driver,WebElement element, int x, int y) {
		Actions actions=new Actions(driver);
		ScrollOrigin origin = ScrollOrigin.fromElement(element);
		actions.scrollFromOrigin(origin, x, y).perform();
	}
	
	public void scrollToElementByAction(WebDriver driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		try {
		actions.scrollToElement(element).perform();
		}
		catch(MoveTargetOutOfBoundsException e) {
			System.out.println("exception handled");
		}
	}
	
	
}
