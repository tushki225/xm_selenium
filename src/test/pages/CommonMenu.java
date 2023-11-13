package test.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.Constants;
import test.utils.WebElementsHelper;

public class CommonMenu {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	//Web Page Object Elements
	String link_researchAndEducation = "RESEARCH & EDUCATION";

	public CommonMenu(WebDriver webdriver){
		this.driver =webdriver;
		explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
	}
	
	//Click different Menu links on top
	public void clickMenu(String link) {
		switch(link) {
		case Constants.RESEARCH_AND_EDUCATION:
			boolean isVisible = WebElementsHelper.isElementDisplayedByLink(driver, link_researchAndEducation);
			if(isVisible)
				driver.findElement(By.partialLinkText(link_researchAndEducation)).click();
			else {
				driver.findElement(By.xpath("//button[@class='toggleLeftNav']")).click();
				WebElementsHelper.scrollIntoViewAndClick(driver, driver.findElement(By.linkText("Research & Education")));
			}
		}
	}
}
