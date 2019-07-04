package in.keys2javaselenium.newtours1.testrunner;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.keys2javaselenium.newtours1.pageobjects.HomePage;
import in.keys2javaselenium.newtours1.pageobjects.RegisterPage;
import in.keys2javaselenium.newtours1.utility.BrowserSelection;
import in.keys2javaselenium.newtours1.utility.XlReader;

public class NewToursRunner {

	WebDriver driver = null;
	HomePage homepg = null;
	RegisterPage rp = null;

	@Parameters({ "bn", "url" })
	@BeforeMethod
	public void init(@Optional("ff") String browserName, @Optional("http://newtours.demoaut.com") String url)
			throws MalformedURLException {
		driver = BrowserSelection.getGridWebBrowser(browserName);
		BrowserSelection.openUrl(url);
		homepg = PageFactory.initElements(driver, HomePage.class);

	}

	@Test(dataProvider = "newtours", dataProviderClass = XlReader.class)
	public void verifyHomePage(String pageTitle, String rownum) {
		String actualPagTitle = homepg.getPageTitle();

		System.out.println(pageTitle);
		System.out.println(actualPagTitle);

		System.out.println(rownum);

		// Assert.assertEquals(actualPagTitle, pageTitle);

		Assert.assertTrue(actualPagTitle.equals(pageTitle));

	}

	@Test(dataProvider = "newtours", dataProviderClass = XlReader.class)
	public void verifyRegistrationProcess(String data1, String data2, String data3, String data4, String data5,
			String data6, String data7, String data8, String data9, String data10, String data11, String data12,
			String data13, String rowNum) {

		homepg.clickRegisterLink5();
		rp = PageFactory.initElements(driver, RegisterPage.class);

		System.out.println(rowNum);
		rp.setFirstName(data1);
		rp.setLasttName(data2);
		rp.setPhoneNumber(data3);
		rp.setEmailAddress(data4);
		
		rp.clickSubmitButton();
		

		// Assert.assertEquals(actualPagTitle, pageTitle);

	}

}
