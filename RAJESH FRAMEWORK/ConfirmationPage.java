package in.keys2javaselenium.newtours1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	private WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public String getConfirmatinMessage()
	{
		return driver.findElement(By.xpath("")).getText();
	}
	
	

}
