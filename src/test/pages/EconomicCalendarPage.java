package test.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.utils.WebElementsHelper;

public class EconomicCalendarPage {
	WebDriver driver;
	WebDriverWait explicitWait;
	Actions builder;
	
	//Web Page Object Elements
	String text_economicCalendar_xpath = "//h2[contains(text(),'Economic Calendar')]";
	String frame_calendar_id="iFrameResizer0";
	String calendar_icon_xpath = "//span[@aria-label='Show time filter']";
	String btn_slider_xpath = "//div[@class='mat-slider-thumb']";
	String calendarView_xpath="//div[@class='tc-slider-timezone-container']";
	String text_date_xpath ="//span[contains(@class, 'tc-economic-calendar-item-header-left-title') and contains(@class, 'tc-normal-text')]";

	public EconomicCalendarPage(WebDriver webdriver){
		this.driver =webdriver;
		builder= new Actions(this.driver);
		explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(30));
	}
	
	//Validate if page is loaded
	public boolean isEconomicCalendarPageLoaded() {
		try {
			boolean isVisible = WebElementsHelper.isElementDisplayedByXpath(driver, text_economicCalendar_xpath);
			if(isVisible)
				return true;
			else {
				switchToCalendarFrame();
				isVisible = WebElementsHelper.isElementDisplayedByXpath(driver, calendar_icon_xpath);
				switchToDefaultPage();
				if(isVisible)
					return true;
				else
					return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Get Page Title
	public String getTitle() {
		return driver.getTitle().trim();
	}
	
	//Switch to calendar frame
	public void switchToCalendarFrame() {
		WebElement iframeElement = driver.findElement(By.id(frame_calendar_id));
		driver.switchTo().frame(iframeElement);
		if(WebElementsHelper.isElementDisplayedByXpath(driver, calendar_icon_xpath)) {
			WebElementsHelper.scrollIntoViewAndClick(driver, driver.findElement(By.xpath(calendar_icon_xpath)));
		}
		else
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(calendarView_xpath))));
			
	}
	
	//Switch to default page
	public void switchToDefaultPage() {
		driver.switchTo().defaultContent();
	}
	
	//Move slider to today's date
	public String selectTodayOnSlider() {
		try {
			WebElement slider =driver.findElement(By.xpath(btn_slider_xpath));
			
			WebElementsHelper.scrollIntoView(driver, driver.findElement(By.xpath("//mat-icon[contains(text(), 'search')]")));
			
			Actions action= builder.moveToElement(slider).click(); 
			action.sendKeys(Keys.ARROW_RIGHT).perform();
			Thread.sleep(2000);
			
			WebElement dayTimeframe =driver.findElement(By.xpath("//span[@class='tc-timeframe']"));
			if (dayTimeframe.getText().trim().equals("Today"))
				return driver.findElements(By.xpath(text_date_xpath)).get(0).getText().trim();
			else
				return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//Move slider to tomorrow's date
	public String selectTomorrowOnSlider() {
		try {
			WebElement slider =driver.findElement(By.xpath(btn_slider_xpath));
	
			builder.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
	
			WebElement dayTimeframe =driver.findElement(By.xpath("//span[@class='tc-timeframe']"));
	
			if (dayTimeframe.getText().trim().equals("Tomorrow"))
				return driver.findElements(By.xpath(text_date_xpath)).get(0).getText().trim();
			else
				return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Move slider to Next week date
	public String selectNextWeekOnSlider() {
		try {
			WebElement slider =driver.findElement(By.xpath(btn_slider_xpath));
	
			builder.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
	
			WebElement dayTimeframe =driver.findElement(By.xpath("//span[@class='tc-timeframe']"));
	
			if (dayTimeframe.getText().trim().equals("Next Week"))
				return driver.findElements(By.xpath(text_date_xpath)).get(0).getText().trim();
			else
				return null;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
