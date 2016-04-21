package automationFramework.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationFramework.PageObjects.CasesPage;
import automationFramework.PageObjects.HomePage;
import automationFramework.Utilities.Logging;
import automationFramework.Utilities.Robots;
import automationFramework.Utilities.Utils;

public class CasesTest {

	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static String RESPONSE1 = "Tolling";
	static WebDriver driver;
	static String browser;

	@Parameters("browser")

	@BeforeMethod
	public void setUp(String browser) {

		// create console and file logging
		Logging.setLogConsole();
		Logging.setLogFile();
		Log.info("Logging Started");
		System.out.println(browser);

		String osname = WindowsUtils.readStringRegistryValue(
				"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\ProductName");
		Log.info("Current OS is: " + osname);

		driver = Utils.openBrowser(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Setup Complete");
	}

	@Test
	public void landingTest() throws Exception {

		CasesPage casePage = new CasesPage(driver);
		String response = casePage.getResponsePage();
		
		/*
		//Execute Assertion
		Assert.assertEquals(response, RESPONSE1);
		Log.info("Expected results " + RESPONSE1 + " matches actual results " + response);
		Log.info("Assertions on Landing Page Completed");
		homePage.clickStart(driver);
		Log.info("Starting Robots");
		

		
		//Handle multiple windows
		Utils.handleMultipleWindows(driver, "Mixxen - Success");
		String title = driver.getCurrentUrl();
		System.out.println(title);
		MixxenSuccessPage successPage = new MixxenSuccessPage(driver);
		Assert.assertEquals(successPage.getSuccessMessage(driver), SUCCESS);
		Log.info("Assertions on Success Page Completed");
		successPage.clickLaunch(driver);

		//Test Music Player Page
		MusicPlayerPage mPage = new MusicPlayerPage(driver);
		Assert.assertEquals(mPage.getSuccessMessage(driver), RADIO);
		mPage.clickLaunch(driver);
		
		//Execute Assertions
		Assert.assertEquals(mPage.searchRadio(driver, ARTIST), ARTIST);
		Log.info("Assertions on Music Page Completed");
		driver.close();


*/
		
	}
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		Reporter.log("TearDown Complete");
		driver.quit();

	}

}