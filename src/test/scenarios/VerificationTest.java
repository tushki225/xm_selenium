package test.scenarios;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.config.TestConfig;
import test.pages.CommonMenu;
import test.pages.EconomicCalendarPage;
import test.pages.EducationalVideosPage;
import test.pages.ResearchAndEducationMenuOptions;
import test.pages.XMHomePage;
import test.utils.Constants;
import test.utils.DateFormatter;

public class VerificationTest extends TestConfig {
	XMHomePage homePage;
	CommonMenu commonMenu;
	ResearchAndEducationMenuOptions researchEducationMenuOptions;
	EconomicCalendarPage economicCalendarPage;
	EducationalVideosPage educationalVideos;

	@BeforeSuite
	public void setUp() {
	 //Initializes driver and Page Objects
	 init();
	 homePage = new XMHomePage(TestConfig.driver);
	 commonMenu = new CommonMenu(TestConfig.driver);
	 researchEducationMenuOptions = new ResearchAndEducationMenuOptions(TestConfig.driver);
	 economicCalendarPage = new EconomicCalendarPage(TestConfig.driver);
	 educationalVideos = new EducationalVideosPage(TestConfig.driver);
	 
	}

	@Test
	@Parameters({"browserSize", "lessonName","lessonTitle"})
	public void performAction(String browserSize, String lessonName, String lessonTitle, ITestContext context) {
		System.out.println(Constants.TESTS_STARTED + context.getName());
		DateFormatter.getNextWeekDate();
		setBrowserSize(browserSize);
		
		//Accept Cookies Option on home Page if visible
		homePage.acceptCookies();
		Assert.assertEquals(homePage.getTitle(),Constants.HOME_PAGE_TITLE);
		Assert.assertTrue(homePage.isHomePageLoaded());
		 
		
		//Navigate to Research and Education Menu
		commonMenu.clickMenu(Constants.RESEARCH_AND_EDUCATION);
		
		//Select Economic Calendar Option and verify Page is loaded
		researchEducationMenuOptions.clickMenuOption(Constants.ECONOMIC_CALENDAR);
		Assert.assertTrue(economicCalendarPage.isEconomicCalendarPageLoaded());
		Assert.assertEquals(economicCalendarPage.getTitle(), Constants.ECONOMIC_CALENDAR);
		 
		
		//Switch to calendar frame, move slider and verify date and then switch to Default Page
		economicCalendarPage.switchToCalendarFrame();
		Assert.assertEquals(economicCalendarPage.selectTodayOnSlider(), DateFormatter.getTodayDate());
		Assert.assertEquals(economicCalendarPage.selectTomorrowOnSlider(), DateFormatter.getTommorowDate());
		Assert.assertEquals(economicCalendarPage.selectNextWeekOnSlider(), DateFormatter.getNextWeekDate()); 
		economicCalendarPage.switchToDefaultPage();
		 
		
		//Click Research and Education Menu and select Research & Education option
		commonMenu.clickMenu(Constants.RESEARCH_AND_EDUCATION);
		researchEducationMenuOptions.clickMenuOption(Constants.EDUCATIONAL_VIDEOS);
		
		//Verify Page is loaded and video can be played
		Assert.assertTrue(educationalVideos.isEducationalVideosPageLoaded());
		Assert.assertEquals(educationalVideos.getTitle(), Constants.EDUCATIONAL_VIDEOS);
		Assert.assertTrue(educationalVideos.selectVideoToStart(lessonName).contains(lessonTitle));

		System.out.println(Constants.TESTS_ENDED + context.getName());
		
	 }

}
