package test.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EducationalVideosPage {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	//Web Page Object Elements
	String text_economicCalendar_xpath = "//h2[contains(text(),'Economic Calendar')]";
	String link_allEducationalVideos_xpath = "//a[contains(@aria-describedby, 'slick-slide')]";
	String btn_videoPlayList_id = "js-videoPlaylist";

	public EducationalVideosPage(WebDriver webdriver){
		this.driver =webdriver;
		explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(30));
	}
	
	//Validate if page is loaded
	public boolean isEducationalVideosPageLoaded() {
		try {
			WebElement playList = driver.findElement(By.id("js-videoPlaylist"));
			explicitWait.until(ExpectedConditions.visibilityOf(playList));
			return driver.findElement(By.id(btn_videoPlayList_id)).isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Get page title
	public String getTitle() {
		return driver.getTitle().trim();
	}
	
	//Start video and play for 10 seconds
	public String selectVideoToStart(String lessonName) { 
		String topicName =null; 
		try {
			List<WebElement> allVideos =driver.findElements(By.xpath(link_allEducationalVideos_xpath)); 
			for (int i=0; i<allVideos.size();i++) {
				if(allVideos.get(i).getText().trim().contains(lessonName)) {
					allVideos.get(i).click(); topicName = driver.findElement(By.xpath("//div[@class='xm-videos__desc']")).getText().trim(); 
					WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Video Player']"));
					iframeElement.click(); 
					TimeUnit.MILLISECONDS.sleep(10000);
					iframeElement.click(); 
					driver.switchTo().defaultContent(); 
					break; 
				} 
			} 
			return topicName; 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
			return null; 
		} 
	}

}
