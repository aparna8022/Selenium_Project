package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class MotorInsuranceOptionPage extends AbstractComponents {
	WebDriver driver;
	
	public MotorInsuranceOptionPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"buy-health-insurance\"]/div/div/div[2]/div/div/div/div[1]/div/a/div")
	WebElement  selectCarInsurance;
	
	
	public CarInsurancePage selectCarInsurance()
	{
		switchWindow();
		selectCarInsurance.click();
		CarInsurancePage carInsurancePage = new CarInsurancePage(driver);
		return carInsurancePage;
	}
}
	