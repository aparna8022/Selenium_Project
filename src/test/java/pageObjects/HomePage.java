package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//WebDriver driver;
public class HomePage
{
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		//super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/span")
	WebElement whatwedo;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/span")
	WebElement Personalinsurance;
	
	
	
	
	public MotorInsurancePage getInsurance()
	{
		Actions a= new Actions(driver);
		a.moveToElement(whatwedo).perform();
		a.moveToElement(Personalinsurance).perform();
		
		MotorInsurancePage motorInsurancePage= new MotorInsurancePage(driver);
		return motorInsurancePage;
	}
	
	public void goTo()
	{
		driver.get("https://www.mahindrainsurance.com/");
	}
	
}

