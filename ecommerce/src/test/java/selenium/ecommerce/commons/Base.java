package selenium.ecommerce.commons;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.ecommerce.pageobjects.BuyNewItemIT;
import selenium.ecommerce.pageobjects.Pages;

public class Base {

	protected static BuyNewItemIT buyNewItem = new BuyNewItemIT();
	protected static Pages pages = null;

	public static WebDriver driver;
	String url = "https://www.extra.com.br";

	public void startBrowser() {
		driver = new ChromeDriver();
	}

	@Before
	public void setURL() {
		startBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}
}
