package com.qc.test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ResgisterTest extends BaseIntegration {

	@BeforeSuite
	public void setup() throws IOException {
		doSetup();
	}
	@BeforeMethod
	public void locateElement() {
		String pageTitle= driver.getTitle();
		if(pageTitle.equals("Queue Codes | Log in")) {
			rLink = driver.findElement(By.linkText("Register a new membership"));
			rLink.click();
		}
		rname =driver.findElement(By.id("name"));
		rname.clear();
		rpass = driver.findElement(By.id("password"));
		rpass.clear();
		remail =driver.findElement(By.id("email"));
		remail.clear();
		rmobile=driver.findElement(By.id("mobile"));
		rmobile.clear();
		rsubmit =driver.findElement(By.className("btn-flat"));
		
	}
	@Test (dataProvider="registerData")
	public void doRegister(String testname,String uName,String uPass,String uEmail,String uMobile) {
		tName =testname;
		rname.sendKeys(uName);
		
		rmobile.sendKeys(uMobile);
		
		remail.sendKeys(uEmail);
		
		rpass.sendKeys(uPass);
		
		rsubmit.click();
	}
	@AfterMethod
	public void doAssert() {
		String expResult,actResult;
		if(tName.equals("all are valid")) {
			Alert alert = driver.switchTo().alert();
		    actResult = alert.getText();
		    alert.accept();
		    expResult = "User registered successfully.";
		    
		    } 
		else {
		 actResult = driver.getTitle();
		 expResult = "Queue Codes | Registration Page";
		
	}
		Assert.assertEquals(expResult, actResult);
		
}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}