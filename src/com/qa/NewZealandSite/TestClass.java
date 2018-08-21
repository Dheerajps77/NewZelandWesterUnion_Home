package com.qa.NewZealandSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass 
{

	public static WebDriver driver;
	public static void main(String[] af) throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver",
				"D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.westernunion.com/nz");
	
		WebElement SendMoneyButton = driver.findElement(By.xpath(
				"//div[@class='button hidden-xs']//a[@data-linkname='sm-image' and @href='/nz/en/send-money/app/start']//span[text()='Send money']"));
		SendMoneyButton.click();
		Thread.sleep(3000);

		WebElement Des_Country = driver.findElement(By.xpath("//input[@id='country']"));
		Des_Country.clear();
		Des_Country.sendKeys("India");
		Des_Country.submit();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Des_Country));
		
		Thread.sleep(4000);
		WebElement Enter_Amount = driver.findElement(By.xpath("//input[@id='txtSendAmount']"));
		Enter_Amount.clear();
		Thread.sleep(2000);
		Enter_Amount.sendKeys("400");
		Thread.sleep(3000);

		WebElement Bank_Account_PayOut = driver.findElement(By.xpath(
				"//div[contains(@class,'wu-thumbnail wu-payout-thumbnail') and @amplitude-id='tile-fundsOut-BA']"));
		Bank_Account_PayOut.click();

	}
}
