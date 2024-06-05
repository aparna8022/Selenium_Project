package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;


import abstractComponents.Excelutility;
import pageObjects.CarInsurancePage;
import pageObjects.HomePage;
import pageObjects.MotorInsuranceOptionPage;
import pageObjects.MotorInsurancePage;

public class InsuranceTest extends BaseTest{
	
	@Test
	
public void BuyInsurance() throws InterruptedException
{
		
try {
	 String testData1= "D:\\car_insurance.xlsx";
	 String SheetName = "Sheet1";
	 int rowCount = Excelutility.getRowCount(testData1, SheetName);
	 System.out.println(rowCount);
				for (int i =1; i<=rowCount;i++)
				{	
					Thread.sleep(1000);	
					HomePage mainPage = launchApplication();
					Thread.sleep(2000);				
			String brandName =Excelutility.getCellValue(testData1,SheetName, i, 0);
					System.out.println("Brand Name---"+brandName);
			String Manufacturing_year =Excelutility.getCellValue(testData1,SheetName, i, 1);
					System.out.println("Manufacturing year---"+Manufacturing_year);
			String Model =Excelutility.getCellValue(testData1,SheetName, i, 2);
					System.out.println("Model---"+Model);
			String Variant =Excelutility.getCellValue(testData1,SheetName, i, 3);
					System.out.println("Variant---"+Variant);
			String FuelType =Excelutility.getCellValue(testData1,SheetName, i, 4);
					System.out.println("Fuel Type---"+FuelType);
			String Invoicedate =Excelutility.getCellValue(testData1,SheetName, i, 5);
					System.out.println("Invoice date---"+Invoicedate); 
			String FullName =Excelutility.getCellValue(testData1,SheetName, i, 6);
					System.out.println("Full Name---"+FullName); 
					
			String MobNo =Excelutility.getCellValue(testData1,SheetName, i, 7);
					System.out.println("Mob No---"+MobNo); 		
			String pinCode =Excelutility.getCellValue(testData1,SheetName, i, 8);
					System.out.println("pincode---"+pinCode); 

	MotorInsurancePage motorInsurancePage =	homePage.getInsurance();
	motorInsurancePage.getMotorInsurance();
	Thread.sleep(1000);	
	String LegalProtectionText = motorInsurancePage.verifyLegalProtectionText();
	Assert.assertEquals("Legal Protection",LegalProtectionText);
	MotorInsuranceOptionPage	motorInsuranceOptionPage= motorInsurancePage.BuyOnline();
	motorInsuranceOptionPage.switchWindow();
	CarInsurancePage carInsurancePage = motorInsuranceOptionPage.selectCarInsurance();
	carInsurancePage.noCarNumber();
	carInsurancePage.vehicleDetails(brandName, Manufacturing_year, Model, Variant, FuelType, Invoicedate);
	carInsurancePage.ConfirmCarDetails();
	carInsurancePage.previousPolicyDetails();
	carInsurancePage.previousClaimDetails();
	carInsurancePage.ProposerDetails(FullName, MobNo, pinCode);
	carInsurancePage.submit();
	
	
			
				}
		}catch (Exception e) {
            e.printStackTrace();
 }
}
}