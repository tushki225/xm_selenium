package test.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.utils.Constants;
import test.utils.WebElementsHelper;

public class ResearchAndEducationMenuOptions {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	//Web Page Object Elements
	String link_economicCalendar = "Economic Calendar";
	String link_educationalVideos = "Educational Videos";

	public ResearchAndEducationMenuOptions(WebDriver webdriver){
		this.driver =webdriver;
		explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
	}
	
	//Click Option under Research and Education Menu
	public void clickMenuOption(String link) {
		boolean isVisible;
		switch(link) {
		case Constants.ECONOMIC_CALENDAR:
			isVisible = WebElementsHelper.isElementDisplayedByLink(driver, link_economicCalendar);
			if(isVisible)
				WebElementsHelper.scrollIntoViewAndClick(driver, driver.findElement(By.partialLinkText(link_economicCalendar)));
			else 
				WebElementsHelper.scrollIntoViewAndClick(driver, driver.findElement(By.linkText("Economic Calendar")));
			
			break;
			
		case Constants.EDUCATIONAL_VIDEOS:
				driver.findElement(By.partialLinkText(link_educationalVideos)).click();
			
			break;
			
		default:
			break;
			
		}
	}
}
