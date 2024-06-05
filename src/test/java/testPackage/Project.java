package testPackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abstractComponents.Excelutility;

//import utilities.ExcelUtilities;

public class Project {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.mahindrainsurance.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void mouse () throws InterruptedException 
	{
		
		 String testData1= "D:\\car_insurance.xlsx";
			String Sheet = "carModel";
				int rowCount = Excelutility.getRowCount(testData1, Sheet);
				for (int i =1; i<=rowCount;i++)
				{
					setup();
					Thread.sleep(1000);
					String brandName =Excelutility.getCellValue(testData1,Sheet, i, 0);
							System.out.println("Brand Name---"+brandName);
					String Manufacturing_year =Excelutility.getCellValue(testData1,Sheet, i, 1);
							System.out.println("Manufacturing year---"+Manufacturing_year);
					String Model =Excelutility.getCellValue(testData1,Sheet, i, 2);
							System.out.println("Model---"+Model);
					String Variant =Excelutility.getCellValue(testData1,Sheet, i, 3);
							System.out.println("Variant---"+Variant);
					String FuelType =Excelutility.getCellValue(testData1,Sheet, i, 4);
							System.out.println("Fuel Type---"+FuelType);
					String Invoicedate =Excelutility.getCellValue(testData1,Sheet, i, 5);
							System.out.println("Invoice date---"+Invoicedate);
							
							Thread.sleep(1000);					
	By mh = By.xpath("//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/span");
	WebElement whatwedo = driver.findElement(mh);
	By Personalinsurance = By.xpath("//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/span");
	WebElement Pi = driver.findElement(Personalinsurance);
	By motorisurance = By.xpath("//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/ul/li[3]/a");
	WebElement min = driver.findElement(motorisurance);
	
	Actions a= new Actions(driver);
	a.moveToElement(whatwedo).perform();
	a.moveToElement(Pi).perform();
	a.moveToElement(min).perform();
	min.click();
	
	
	By Benefits= By.className("policyaccordion-title");
	//JavascriptExecutor js =(JavascriptExecutor) driver;
	//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("ul[class='list-group'] li:nth-child(2) a")));
	List<WebElement> li =driver.findElements(Benefits);
	Assert.assertEquals("Legal Protection", li.get(4).getText());
	JavascriptExecutor js =(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 4500);");
	  Thread.sleep(1000);
	

	  driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div/section[5]/div/div[4]/div/div/div/div/ul/li[2]/a")).click();
	Set<String> allwindowHandles = driver.getWindowHandles();
		Iterator<String> it= allwindowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		 js.executeScript("window.scrollBy(0, 500);");
		 driver.findElement(By.xpath("//*[@id=\"buy-health-insurance\"]/div/div/div[2]/div/div/div/div[1]/div/a/div")).click();
		 driver.findElement(By.id("no-car-number")).click();
	WebElement vehiclebrand= 	driver.findElement(By.id("vehicle-brand"));
	vehiclebrand.click();
	vehiclebrand.sendKeys(brandName);
	Thread.sleep(1000);
	WebElement year= 	driver.findElement(By.id("manufacturing-year"));
				year.click();
				year.sendKeys(Manufacturing_year);
				Thread.sleep(2000);
				
				WebElement veh_model= 	driver.findElement(By.id("vehicle-model"));
				veh_model.click();
				veh_model.sendKeys(Model);
				Thread.sleep(2000);
				WebElement veh_variant= 	driver.findElement(By.id("vehicle-variant"));
				veh_variant.click();
				veh_variant.sendKeys(Variant);
				Thread.sleep(2000);
				WebElement veh_fuel= 	driver.findElement(By.id("vehicle-fuel"));
				veh_fuel.click();
				veh_fuel.sendKeys(FuelType);
				
				Thread.sleep(2000);
				WebElement invoicedate= 	driver.findElement(By.xpath("//input[@id='invoice-date']"));
				invoicedate.click();
				invoicedate.sendKeys(Invoicedate);
				
		 
		 
		 
		 
		 driver.findElement(By.cssSelector("button[onClick='confirmCarDetails()']")).click();
		// JavascriptExecutor js =(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 1500);");
		
		 WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			    
			driver.findElement(By.linkText("Confirm Vehicle")).click();
			
			driver.findElement(By.className("policy-expiry-status"));
	
				}
	
	}
	
}
