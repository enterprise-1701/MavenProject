package automationFramework.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Utils {

	public static WebDriver driver = null;

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitTime(long milliseconds) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		Thread.sleep(milliseconds);
	}

	public static void isLoaded(WebDriver driver, String title) {
		Assert.assertTrue(driver.getTitle().equals(title));
	}

	public static WebDriver openBrowser(String browser) {

		try {
			if (browser.equals("firefox.exe")) {
				driver = new FirefoxDriver();
				Reporter.log("firefox driver instantiated");

			} else if (browser.equals("chrome.exe")) {
				System.setProperty("webdriver.chrome.driver",
						"C:/ChromeDriver/chromedriver.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				Reporter.log("chrome driver instantiated");

			}

		} catch (Exception e) {
			Reporter.log("Utils.openBrowser failed");
		}
		return driver;
	}

	// capturing screenshots of the scripts
	public static void getScreenShot() throws Exception {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:/Automation/ScreenShots/" + System.currentTimeMillis() + "_screenshot.png"));
			Reporter.log("Screenshot Captured");
		} catch (IOException e) {
			Reporter.log("Failed to capture screenshot");
		}
	}
    
	// handling multiple windows and selecting the right one
	public static void handleMultipleWindows(WebDriver driver, String windowTitle) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(windowTitle)) {
				return;
			}
		}
	}

}