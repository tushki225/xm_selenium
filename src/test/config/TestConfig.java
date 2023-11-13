package test.config;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import test.utils.Constants;

public class TestConfig {
	public static WebDriver driver;
	public static String baseUrl;
	private static FileReader reader;
	private static String OS = System.getProperty(Constants.OS_IDENTIFIER).toLowerCase();

	public void init() {
		TestConfig.readPropertiesFile();

		if(OS.contains(Constants.WINDOWS_OS))
			System.setProperty("webdriver.chrome.driver",System.getProperty(Constants.USER_DIR_IDENTIFIER)+Constants.WIN_CHROME_DRIVER);
		else
			System.setProperty("webdriver.chrome.driver",System.getProperty(Constants.USER_DIR_IDENTIFIER)+Constants.MAC_CHROME_DRIVER);

	    if (driver==null) {
	    	driver = new ChromeDriver();
		    driver.navigate().to(TestConfig.getBaseUrl());
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    }
	}
	
	public static void setBrowserSize(String size) {
		if(size.equals("maximum"))
			driver.manage().window().maximize();
		else {
			int width = Integer.parseInt(size.split("*")[0]);
			int height = Integer.parseInt(size.split("*")[1]);
			Dimension newDimension = new Dimension(width, height);
			driver.manage().window().setSize(newDimension);
		}
	}

	public static void readPropertiesFile (){
		try {
			Properties prop;
			if(OS.contains(Constants.WINDOWS_OS))
				reader = new FileReader(System.getProperty(Constants.USER_DIR_IDENTIFIER)+Constants.WIN_PROPERTIES_FILE_PATH);
			else
				reader = new FileReader(System.getProperty(Constants.USER_DIR_IDENTIFIER)+Constants.MAC_PROPERTIES_FILE_PATH);

			prop = new Properties();
			prop.load(reader);

			baseUrl= prop.getProperty("baseURL");

		} catch (Exception e) {
			e.getMessage();
	  	}
	}

	public static String getBaseUrl (){
		return baseUrl;
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
