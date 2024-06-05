package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pageObjects.HomePage;




public class BaseTest {
	
	public WebDriver driver;
	public HomePage homePage;
	
	public WebDriver initializeDriver()
	{
	
	
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.mahindrainsurance.com/");
	driver.manage().window().maximize();
	return driver;
	}
	
	public HomePage launchApplication()
	{
		driver = initializeDriver();
		 homePage = new HomePage(driver);
		 homePage.goTo();
		return homePage;
	}
}
