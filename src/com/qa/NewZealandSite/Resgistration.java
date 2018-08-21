package com.qa.NewZealandSite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Resgistration
{
	
	public static void main(String[] arf) throws InterruptedException{
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.westernunion.com/nz");
		
		//System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
				//driver = new FirefoxDriver();
		driver.findElement(By.xpath("//div[contains(@class,'row header-top-container')]//li[8]//a")).click();
		driver.findElement(By.xpath("//input[@aria-describedby='txtFNameSuccess' and @id='txtFName']")).sendKeys("Dheeraj");
		driver.findElement(By.xpath("//input[@aria-describedby='txtFNameSuccess' and @id='txtMName']")).sendKeys("Pratap");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='chkMiddleNameOptional']//following::label[1]")).click();
		driver.findElement(By.xpath("//input[@id='txtLName']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='mergeDob']")).sendKeys("26/12/1992");
		driver.findElement(By.xpath("//input[@id='txtEmailAddr']")).sendKeys("arwuprous1@yopmail.com");
		driver.findElement(By.xpath("//input[@id='txtKey']")).sendKeys("Password1");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath("//input[@id='txtAddr']")).sendKeys("12 Hudson Bay Road Extension");
		driver.findElement(By.xpath("//translate[@class='checkTarget ng-scope']")).click();
		driver.findElement(By.xpath("//input[@id='txtAddrLine2']")).sendKeys("12-Greateer Kailash");
		driver.findElement(By.xpath("//input[@id='txtCity']")).sendKeys("Auckland");
		driver.findElement(By.xpath("//input[@id='cboState']")).sendKeys("Auckland");
		driver.findElement(By.xpath("//input[@id='txtZipCode']")).sendKeys("0618");
		
		
		WebElement PNumber=driver.findElement(By.xpath("//select[@id='cboPrimaryPhoneTypes']"));
		Select Phone_Numer=new Select(PNumber);
		//PNumber.click();
		Thread.sleep(2000);
		Phone_Numer.selectByVisibleText("Home");
		//PNumber.submit();
		
		WebElement CountryISD_selction=driver.findElement(By.xpath("//select[@id='txtCountryCode']"));
		Select CountryISD=new Select(CountryISD_selction);
		//CountryISD_selction.click();
		Thread.sleep(2000);
		CountryISD.selectByVisibleText("91 (IN)");
		//CountryISD_selction.submit();
		
		/*List<WebElement> getSizeOfPhoneCode=CountryISD.getOptions();
		int total_size=getSizeOfPhoneCode.size();
		System.out.println(total_size);
		for(int i=0;i<total_size;i++)
		{
			String text=getSizeOfPhoneCode.get(i).getText();
			System.out.println(text);
		}*/
		
		driver.findElement(By.xpath("//input[@id='txtPhoneNum1']")).sendKeys("9090000099");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@amplitude-id='radio-gender-male']")).click();
		
		WebElement Occupation=driver.findElement(By.xpath("//select[@id='occupationField']"));
		Select O_occupation=new Select(Occupation);
		//Occupation.click();
		O_occupation.selectByVisibleText("Unemployed");
		Thread.sleep(2000);
		//Occupation.submit();
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,300)");
		
		WebElement CountryOfBirth=driver.findElement(By.xpath("//select[@id='countryOfBirthField']"));
		Select Select_CountryOfBirth=new Select(CountryOfBirth);
		Select_CountryOfBirth.selectByVisibleText("India");
		//CountryOfBirth.click();
		Thread.sleep(2000);
		//CountryOfBirth.submit();
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		WebElement SecurityQ=driver.findElement(By.xpath("//select[@id='cboSecurityQues']"));
		Select select_SecurityQ=new Select(SecurityQ);
		//SecurityQ.click();
		select_SecurityQ.selectByVisibleText("What is your pet's name?");
		Thread.sleep(2000);
		//SecurityQ.submit();
		
		driver.findElement(By.xpath("//input[@id='txtAns']")).sendKeys("White mouse");
		Thread.sleep(2000);
		
		WebElement checkbox1=driver.findElement(By.xpath("//label[@for='chklegalTermsAndConditions']"));
		//Actions check1=new Actions(driver);
		//check1.moveToElement(checkbox1).build().perform();
		checkbox1.click();
		
		
		WebElement checkbox2=driver.findElement(By.xpath("//label[@for='chkMarketingOptions']"));
		//Actions check2=new Actions(driver);
		//check2.moveToElement(checkbox2).build().perform();
		checkbox2.click();
		
		driver.findElement(By.xpath("//button[@id='button-continue']")).click();
		
		
	}

}
