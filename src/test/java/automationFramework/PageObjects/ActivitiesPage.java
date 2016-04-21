package automationFramework.PageObjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.WebClient;

import automationFramework.Utilities.Constant;
import automationFramework.Utilities.Utils;

public class ActivitiesPage extends BaseClass {

	public static Pattern p1;

	// Element Locators
	private static final String START = "//*[@id='lp-pom-button-763']";	
	private static final String FFACCEPT = ".//*[@id='fi-ext-accept']";

	public ActivitiesPage(WebDriver driver) {
		super(driver);
	}

	public String getResponsePage() throws Exception {

		try {
			driver.get(Constant.URL1);
			int code = getStatusCode(200);
			System.out.println("Status code is:" + code);
			String content = getPageContent();

			String regex = "Mixxen";
			String result = null;
			Matcher matcher = Pattern.compile(regex).matcher(content);

			while (matcher.find()) {
				result = matcher.group();
			}

			return result;

		} catch (Exception e) {
			Reporter.log("mixxen page not Found");
			throw (e);
		}

	}

	public void clickStart(WebDriver driver) throws InterruptedException, AWTException {
		driver.findElement(By.xpath(START)).click();
		Utils.waitTime(3000);
	}

	public void clickStartFF(WebDriver driver) throws InterruptedException, AWTException {
		driver.findElement(By.xpath(START)).click();
		Utils.waitTime(3000);
		driver.findElement(By.xpath(FFACCEPT)).click();
		Utils.waitTime(8000);
	}

	public static int getStatusCode(long appUserId) throws IOException {
		WebClient webClient = new WebClient();
		int code = webClient.getPage(Constant.URL1).getWebResponse().getStatusCode();
		return code;
	}

	public static String getPageContent() throws IOException {
		WebClient webClient = new WebClient();
		String content = webClient.getPage(Constant.URL1).getWebResponse().getContentAsString();
		return content;
	}

	public String getCookie(String cookie) {
		driver.get(Constant.URL1);
		Set<Cookie> cookies = driver.manage().getCookies();
		Cookie UID = driver.manage().getCookieNamed(cookie);
		return UID.getValue();
	}

}