package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws Throwable {
		System.out.println("Before suite");
	}

	// @Parameters("BROWSER")
	// String BROWSER
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		String BROWSER = System.getProperty("browser");
//		
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("firefox");
		} else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToAppln() throws Throwable {
		System.out.println("before method");

	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromAppln() {
		System.out.println("After method");

	}

	@AfterClass(alwaysRun = true)
	public void logout() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void disConnectToDB() throws Exception {
		System.out.println("after suite");
	}

}
