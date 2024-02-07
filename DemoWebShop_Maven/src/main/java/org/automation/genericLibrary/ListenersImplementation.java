package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot screenshot=(TakesScreenshot)BaseTest.listenerDriver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshots/"+result.getName()+".png");
		try {
			FileHandler.copy(src, trg);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
