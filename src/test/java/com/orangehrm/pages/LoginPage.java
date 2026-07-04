package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//public class LoginPage {
//	WebDriver driver;
//	// locator using find by for user field
//	@FindBy(xpath = "//input[@name='username']")
//	private WebElement userfield;
//
//	@FindBy(xpath = "//input[@name='password']")
//	private WebElement passwordfield;
//
//	@FindBy(xpath = "//button[@type='submit']")
//	private WebElement loginbutton;
//
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this); // initializes all @FindBy elements
//	}
//
//	// Actions
//	public void enterUsername(String user) {
//		userfield.sendKeys(user);
//
//	}
//
//	public void enterPassword(String pass) {
//		passwordfield.sendKeys(pass);
//
//	}
//
//	public void clickLogin() {
//		loginbutton.click();
//
//	}

//	 public void login(String username, String password) {
//		
//		        userfield.clear();
//		        userfield.sendKeys(username);
//
//		        passwordfield.clear();
//		        passwordfield.sendKeys(password);
//
//		        loginbutton.click();
//	    }

//}





public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

  //locator using find by for user field
 	@FindBy(xpath = "//input[@name='username']")
 	private WebElement userfield;
 
 	@FindBy(xpath = "//input[@name='password']")
 	private WebElement passwordfield;
 

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginbutton;

    public LoginPage(WebDriver driver) { // Constructor for LoginPage: requires a WebDriver instance 
    	// so this page object can use the same browser session

        this.driver = driver; // Assign the WebDriver instance passed from the test class 
     // to the class-level variable 'driver' so all page methods 
     // can use the same browser session.
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Initialize all @FindBy annotated WebElements in this class 
        // using the given WebDriver, so they are ready to interact 
        // without writing driver.findElement(...) manually.

    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(userfield));
        userfield.clear();
        userfield.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(passwordfield));
        passwordfield.clear();
        passwordfield.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
        loginbutton.click();
    }
}
