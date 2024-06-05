package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class MotorInsurancePage extends AbstractComponents{

WebDriver driver;
	
	public MotorInsurancePage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(className="policyaccordion-title")
	List<WebElement>  Benefits;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div/section[5]/div/div[4]/div/div/div/div/ul/li[2]/a")
	WebElement buyOnline;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/ul/li[3]/a")
	WebElement motorinsurance;
	
	public String verifyLegalProtectionText()
	{
		return Benefits.get(4).getText();
		
	}
	
	public void getMotorInsurance()
	{
		Actions a= new Actions(driver);
		a.moveToElement(motorinsurance).perform();
		motorinsurance.click();
	}
	public MotorInsuranceOptionPage BuyOnline() throws InterruptedException
	{
		ScrollBy(0, 4500);
		buyOnline.click();
		MotorInsuranceOptionPage motorInsuranceOptionPage = new MotorInsuranceOptionPage(driver);
		return motorInsuranceOptionPage;
	}
}
