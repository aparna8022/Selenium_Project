package abstractComponents;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponents {
	
WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	public void ScrollBy(int i, int j) throws InterruptedException
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy("+ i +", "+ j +");");
		  Thread.sleep(1000);	
	}

	public void switchWindow()
	{
		Set<String> allwindowHandles = driver.getWindowHandles();
		Iterator<String> it= allwindowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
	}
	
	public void waitTime() throws InterruptedException
	{
		Thread.sleep(2000);
	}
}