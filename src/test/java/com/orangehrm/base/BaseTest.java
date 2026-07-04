package com.orangehrm.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.ExtentListener;

public class BaseTest {

	public WebDriver driver;

//	@BeforeMethod
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//	}
//
//}
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional String browser) throws IOException {
		ConfigReader.loadConfig();
		//String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		
		// If no parameter passed, use config value
	    if (browser == null || browser.isEmpty()) {
	        browser = ConfigReader.getProperty("browser");
	    }

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
	     else if (browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver();
	    } else if (browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    }
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 // Pass driver to ExtentListener
        ExtentListener.driver = driver;
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
