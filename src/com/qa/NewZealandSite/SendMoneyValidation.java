package com.qa.NewZealandSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendMoneyValidation {
	public static WebDriver driver;

	// System.setProperty("webdriver.chrome.driver",
	// "D:\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");

	// driver = new ChromeDriver();

	// System.setProperty("webdriver.gecko.driver",
	// "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	// driver = new FirefoxDriver();

	
	@BeforeTest
	public void OpenBroswer(){
		
		System.setProperty("webdriver.gecko.driver",
				"D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.westernunion.com/nz");
	}
	@Test
	public void SendMoneyFlowModule() throws InterruptedException 
	{

		WebElement SendMoneyButton = driver.findElement(By.xpath(
				"//div[@class='button hidden-xs']//a[@data-linkname='sm-image' and @href='/nz/en/send-money/app/start']//span[text()='Send money']"));
		SendMoneyButton.click();
		Thread.sleep(3000);

		WebElement Des_Country = driver.findElement(By.xpath("//input[@id='country']"));
		Des_Country.clear();
		Thread.sleep(4000);
		Des_Country.sendKeys("India");
		Des_Country.submit();
		
		Thread.sleep(4000);
		WebElement Enter_Amount = driver.findElement(By.xpath("//input[@id='txtSendAmount']"));
		Enter_Amount.clear();
		Thread.sleep(2000);
		Enter_Amount.sendKeys("400");
		Thread.sleep(3000);

		WebElement Bank_Account_PayOut = driver.findElement(By.xpath(
				"//div[contains(@class,'wu-thumbnail wu-payout-thumbnail') and @amplitude-id='tile-fundsOut-BA']"));
		Bank_Account_PayOut.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");

		Thread.sleep(3000);
		WebElement Credit_Debit_CardButton = driver
				.findElement(By.xpath("//div[@amplitude-id='tile-fundsIn-CreditCard']//div"));
		boolean check = Credit_Debit_CardButton.isSelected();

		if (check) {
			String str = Credit_Debit_CardButton.getText();
			System.out.println(str);
		} else {
			Credit_Debit_CardButton.click();
		}

		WebElement Promo_code_link = driver.findElement(By.xpath("//translate[text()='I have a promo code']"));
		Promo_code_link.click();
		Thread.sleep(2000);

		WebElement Promo_code_text = driver.findElement(By.xpath("//input[@id='txtPromoCd']"));
		Promo_code_text.sendKeys("KSJJS-3248372");

		WebElement Apply_promoCode_button = driver.findElement(By.xpath("//button[@id='applyPromoCode']"));
		Apply_promoCode_button.click();

		String Error_Message = driver.findElement(By.xpath("//span[@id='notification-message']")).getText();
		System.out.println("==================================================");
		System.out.println(Error_Message);

		Thread.sleep(2000);

		WebElement Dont_have_promo_code_link = driver.findElement(By.xpath("//a[@id='anchorHidePromoCode']"));

		Actions action = new Actions(driver);
		action.moveToElement(Dont_have_promo_code_link).build().perform();
		Dont_have_promo_code_link.click();

		Thread.sleep(2000);

		WebElement SMO_ContinueButton = driver
				.findElement(By.xpath("//button[@data-linkname='button-smo-continue']//translate"));
		SMO_ContinueButton.click();

		Thread.sleep(2000);

		WebElement login_text = driver.findElement(By.xpath("//input[@id='txtEmailAddr']"));
		login_text.sendKeys("dheerajie3323nz@yopmail.com");

		WebElement password_text = driver.findElement(By.xpath("//input[@id='txtKey']"));
		password_text.sendKeys("India@123");

		WebElement Submit_button = driver.findElement(By.xpath("//button[@id='button-continue']"));
		Submit_button.click();

		WebElement Addition_Receiver = driver.findElement(By.xpath(
				"//div[@automation-id='addNewReceiver']//div//img//following::div[1]//translate[text()='Add a new receiver']"));

		Actions action1 = new Actions(driver);
		action1.moveToElement(Addition_Receiver).build().perform();
		Addition_Receiver.click();
		Thread.sleep(3000);

		Actions action2 = new Actions(driver);
		action2.moveToElement(Addition_Receiver).build().perform();
		Addition_Receiver.click();
		Thread.sleep(3000);
		Addition_Receiver.click();
	}
	
	@AfterMethod
	public void CloseBroswer(){
		
	}
}
