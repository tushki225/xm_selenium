package test.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XMHomePage {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	//Web Page Object Elements
	String btn_acceptCookie_xpath = "//button[@aria-label=\"Close\" and text()=\"ACCEPT ALL\"]";
	String link_openAccount = "OPEN AN ACCOUNT";
	String link_researchEducation = "RESEARCH & EDUCATION";

	public XMHomePage(WebDriver webdriver){
		this.driver =webdriver;
		explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
	}
	
	//Accept cookies if visible
	public void acceptCookies() {
		WebElement acceptCookieButton = driver.findElement(By.xpath(btn_acceptCookie_xpath));
		if(acceptCookieButton.isDisplayed()) {
			acceptCookieButton.click();
			explicitWait.until(ExpectedConditions.invisibilityOf(acceptCookieButton));
		}
	}
	
	//Validate if page is loaded
	public boolean isHomePageLoaded() {
		try {
			return driver.findElement(By.partialLinkText(link_openAccount)).isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Get Page title
	public String getTitle() {
		return driver.getTitle().trim();
	}
}
