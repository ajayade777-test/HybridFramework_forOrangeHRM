package without_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class withoutframework {
	
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void Login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Login Successful" , true);
		
	}
	
	@Test
	public void Dashboard() {
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		Reporter.log("clicked on Dashboard" , true);
	}
	
	@Test
	public void PIM() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Reporter.log("clicked on PIM Menu" , true);
	}
	
	@AfterClass
	public void close() {
		//driver.close();
		
	}

}
