package in.keys2javaselenium.newtours1.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import bsh.Remote;

public class BrowserSelection {

	private static WebDriver driver = null;

	public static WebDriver getWebBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\BrowserExes\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\BrowserExes\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("phantom")) {
			System.setProperty("phantomjs.binary.path", ".\\BrowserExes\\phantomjs.exe");
			driver = new PhantomJSDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\BrowserExes\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static WebDriver getGridWebBrowser(String browserName) throws MalformedURLException{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\BrowserExes\\chromedriver.exe");
			
			DesiredCapabilities dc =  DesiredCapabilities.chrome();
			dc.setBrowserName("gc");
			dc.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL
					("http://localhost:5566/wd/hub"), dc);
		
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\BrowserExes\\IEDriverServer.exe");
			
			DesiredCapabilities dc =  DesiredCapabilities.internetExplorer();
			dc.setBrowserName("headless");
			dc.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL
					("http://localhost:5567/wd/hub"), dc);
		
		
		} else if (browserName.equalsIgnoreCase("phantom")) {
			System.setProperty("phantomjs.binary.path", ".\\BrowserExes\\phantomjs.exe");
			
			DesiredCapabilities dc =  DesiredCapabilities.phantomjs();
			dc.setBrowserName("headless");
			dc.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL
					("http://localhost:5566/wd/hub"), dc);
		
		
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\BrowserExes\\geckodriver.exe");
			
			DesiredCapabilities dc =  DesiredCapabilities.firefox();
			dc.setBrowserName("ff");
			dc.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL
					("http://localhost:5567/wd/hub"), dc);
		
		}
		return driver;
	
	
	}
	
	
	
	
	
	
	
	
	public static void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static String getCurrentDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_YYYY hh_mm_ss");
		Date d = new Date();

		return sdf.format(d);
	}

	public static void getScreenShot() throws IOException {
		String destination = "C:\\Temp\\"+getCurrentDate()+" "
	+driver.getTitle().replace(":","_").replace("\\", "_")+".png";
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination));
	}

}
