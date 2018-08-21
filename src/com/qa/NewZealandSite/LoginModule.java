package com.qa.NewZealandSite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginModule {
	
	WebDriver driver;
	
	String path="D:\\Eclipse selenium Program\\WesterUnion\\ObjectLocators\\LoginObject.properties";
	File fs=new File(path);
	FileInputStream fis=null;
	Properties prop=new Properties();

	
	@BeforeTest
	public void OpeningBroswer() throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
		fis=new FileInputStream(fs);
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
	}
	
	@Test
	public void Login()throws IOException
	{
		fis=new FileInputStream(fs);
		prop.load(fis);
		
		driver.findElement(By.xpath(prop.getProperty("Login_Link"))).click();
		driver.findElement(By.xpath(prop.getProperty("EmailID_textField"))).sendKeys("DheerajpSingh@gmail.com");
		driver.findElement(By.xpath(prop.getProperty("Password_textField"))).sendKeys("Password1");
		driver.findElement(By.xpath(prop.getProperty("Submit_button"))).click();
		
	}
	@AfterClass
	public void ClosingBrowser()
	{
		driver.close();
	}

}
