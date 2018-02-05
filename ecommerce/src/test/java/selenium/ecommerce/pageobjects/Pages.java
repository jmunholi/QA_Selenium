package selenium.ecommerce.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.ecommerce.commons.Base;

public class Pages extends Base {

	public void login(String email, String pass) {
		String mailPath = ".//input[@id='Email']";
		String passPath = ".//input[@id='Senha']";

		clickOn(".//*[@id='lnkCadastreSe']");

		waitForComponentVisible(mailPath);
		clickOn(mailPath);
		sendKeys(mailPath, email);

		clickOn(passPath);
		sendKeys(passPath, pass);

		clickOn(".//*[@id='btnClienteLogin']");
		
		String usr = getElementText(".//span[@id='lblLoginMsg']");
		if (!usr.equals("robson")) {
			Assert.assertTrue(false);
		}
	}

	public void clickOn(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void sendKeys(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public String findElement(String xpath) {
		driver.findElement(By.xpath(xpath));
		return xpath;
	}
	
	public String getElementText(String xpath) {
		String element = driver.findElement(By.xpath(xpath)).getText();
		return element;
	}

	public void clearField(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	public void waitForComponentVisible(String component) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(component)));
	}

	public void waitForComponentToBeClickable(String component) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(component)));
	}

	public void mouseHoverAndClickOn(String xpath) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(xpath));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
	}

}
