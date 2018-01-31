package selenium.ecommerce.commons;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import junit.framework.Assert;
import selenium.ecommerce.pageobjects.Pages;
import selenium.ecommerce.tests.BuyNewItem;

public class Base {

	BuyNewItem buyNewItem = new BuyNewItem();
	Pages pages = new Pages();
	
	public WebDriver driver;
	String browser = "Firefox";

	@BeforeClass
	public void startBrowser() {
		browser = browser.toUpperCase();
		if ("FIREFOX".equals(browser)) {
			driver = new FirefoxDriver();
		} 
		else 
			if ("CHROME".equals(browser)) {
			driver = new ChromeDriver();
		}
		else 
			if ("SAFARI".equals(browser)) {
			driver = new SafariDriver();
		} 
		else {
			System.out.println("Selected browser not supported");
			Assert.assertTrue(false);
		}
	}

	public void setURL(String url) {
		driver.get(url);
	}
}
