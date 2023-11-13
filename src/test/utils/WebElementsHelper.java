package test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsHelper {
	
	public static boolean isElementDisplayedByLink(WebDriver driver, String element) {
		try {
			scrollIntoView(driver, driver.findElement(By.partialLinkText(element)));
			return driver.findElement(By.partialLinkText(element)).isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}
		
	public static void scrollIntoViewAndClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollUp(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	public static void scrolldown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	public static boolean isElementDisplayedByXpath(WebDriver driver, String element) {
		try {
			return driver.findElement(By.xpath(element)).isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
	}
		
	

}
