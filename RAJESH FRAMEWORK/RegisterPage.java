package in.keys2javaselenium.newtours1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private WebDriver driver = null;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName(String fn) {
		driver.findElement(By.name("firstName")).sendKeys(fn);
	}

	public void setLasttName(String ln) {
		driver.findElement(By.name("lastName")).sendKeys(ln);
	}

	public void setPhoneNumber(String phno) {
		driver.findElement(By.name("phone")).sendKeys(phno);
	}

	public void setEmailAddress(String emailid) {
		driver.findElement(By.name("userName")).sendKeys(emailid);
	}

	
	public void clickSubmitButton()
	{
		driver.findElement(By.name("register")).click();
	}
}
