package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class CarInsurancePage extends AbstractComponents{
	
	WebDriver driver;
	public CarInsurancePage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="no-car-number")
	WebElement noCarNumber ;
	
	@FindBy(id="vehicle-brand")
	WebElement vehicleBrand ;
	
	@FindBy(id="manufacturing-year")
	WebElement manufacturingYear ;
	
	@FindBy(id="vehicle-model")
	WebElement vehiclemodel ;
	
	@FindBy(id="vehicle-variant")
	WebElement vehicleVariant ;

	@FindBy(id="vehicle-fuel")
	WebElement vehicleFuel ;
	
	@FindBy(id="invoice-date")
	WebElement InvoiceDate ;
	
	@FindBy(css="button[onClick='confirmCarDetails()']")
	WebElement confirmCarDetails ;
	
	@FindBy(tagName="body")
	WebElement element ;
	
	@FindBy(linkText="Confirm Vehicle")
	WebElement ConfirmVehicle ;
	
	@FindBy(xpath="//label[@for='expired-no']")
	WebElement PolicyExpired ;
	
	@FindBy(xpath="//*[@id='step3']/div[3]/div/button")
	WebElement continue1 ;
	
	@FindBy(xpath="//*[@id='step4']/div[2]/div[1]/div/div/label")
	WebElement previousClaim ;
	
	@FindBy(xpath="//*[@id='step4']/div[4]/div/button")
	WebElement continue2 ;
	
	
	@FindBy(xpath="//*[@id='full-name']")
	WebElement fullname ;
	
	@FindBy(xpath="//*[@id='mobile-number']")
	WebElement Mobnumber ;
	
	@FindBy(xpath="//*[@id='pincode']")
	WebElement pincode ;
	//*[@id='wizard-submit']
	
	@FindBy(xpath="//*[@id='wizard-submit']")
	WebElement Submit ;
	
	
	@FindBy(xpath="//*[@id='otpmodal']/div/div/div[1]/button/span/img")
	WebElement close ;
	
	public void noCarNumber()
	{
		noCarNumber.click();
	}
	
	public void vehicleDetails(String brandName, String Manufacturing_year, String Model, 
			String Variant, String FuelType, String Invoicedate) throws InterruptedException
	{
		
		waitTime();
		vehicleBrand.click();
		vehicleBrand.sendKeys(brandName);
		waitTime();
		manufacturingYear.click();
		manufacturingYear.sendKeys(Manufacturing_year);
		vehiclemodel.click();
		vehiclemodel.sendKeys(Model);
		vehicleVariant.click();
		vehicleVariant.sendKeys(Variant);
		vehicleFuel.click();
		vehicleFuel.sendKeys(FuelType);
		InvoiceDate.click();
		InvoiceDate.sendKeys(Invoicedate);
	} 
	
	public void ConfirmCarDetails() throws InterruptedException
	{
		confirmCarDetails.click();
		ScrollBy(0, 1500);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
		ConfirmVehicle.click();
	}
	
	public void previousPolicyDetails()
	{
		PolicyExpired.click();
		continue1.click();
	}
	
	public void previousClaimDetails()
	{
		previousClaim.click();
		continue2.click();
	}
	
	public void ProposerDetails(String FullName, String MobNo, String pinCode )
	{
		fullname.sendKeys(FullName);
		Mobnumber.sendKeys(MobNo);
		pincode.sendKeys(pinCode);
	}
	
	public void submit()
	{
		Submit.click();
		close.click();
	}
}
