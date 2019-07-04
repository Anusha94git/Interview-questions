package in.keys2javaselenium.newtours1.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage { 
	
	private WebDriver driver=null;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickRegisterLink()
	{
		WebDriverWait ww = new WebDriverWait(driver,50);
		
		WebElement reglink = ww.until
		(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//a[contains(text(),'REGISTER')]")));
		
		reglink.click();
		
	}
	
	public void clickRegisterLink2()
	{
		FluentWait<WebDriver> fw = new FluentWait(driver);
		fw.withTimeout(120, TimeUnit.SECONDS);
		fw.pollingEvery(5, TimeUnit.SECONDS);
		
		WebElement reglink1 = fw.until
		(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//a[contains(text(),'REGISTER')]")));
		
		reglink1.click();
	}

	public void clickRegisterLink3()
	{
	
		WebElement reglink1 = driver.findElement
				(By.xpath("//a[contains(text(),'REGISTER')]"));
		
		reglink1.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]") 
	private WebElement regl;
	public void clickRegisterLink4()
	{
		regl.click();	
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'REGISTER')]") 
	private WebElement regl2;
	public void clickRegisterLink5()
	{
		
		regl2.click();	
	}


}
