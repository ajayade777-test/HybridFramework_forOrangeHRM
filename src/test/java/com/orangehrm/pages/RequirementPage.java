package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequirementPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//locate all elements using @find By
	@FindBy(xpath="//span[text()='Recruitment']")
	WebElement clkOnReqMemu;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clkOnAdd;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement Name;
	
	@FindBy(xpath="//input[@name='middleName']")
	WebElement mdlName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@class='oxd-select-wrapper']")
	WebElement vacancy;
	
	@FindBy(xpath="(//input[@placeholder='Type here'])[1]")
	WebElement Email;
	
	@FindBy(xpath="(//input[@placeholder='Type here'])[2]")
	WebElement Contact;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement resumefile;
	
	@FindBy(xpath="//input[@placeholder='Enter comma seperated words...']")
	WebElement keyword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[2]/div/div[2]/div/div/input")
	WebElement date;
	
	@FindBy(xpath="//textarea[@placeholder='Type here']")
	WebElement Notes;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
	WebElement checkbox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	
	//now create the constructor for initialize the all @find by elements and driver
	public RequirementPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void clkrqrMenu() {
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(clkOnReqMemu));
		menu.click();  

	}
	public void clkOnadd() {
		wait.until(ExpectedConditions.elementToBeClickable(clkOnAdd)).click();
	}
	
	public void allDetails(String name, String midlname, String lstname, String email, String contNum, String kwrd, String notes) throws InterruptedException {
		Name.clear();
		Name.sendKeys(name);
		mdlName.clear();
		mdlName.sendKeys(midlname);
		lastname.clear();
		lastname.sendKeys(lstname);
		wait.until(ExpectedConditions.elementToBeClickable(vacancy)).click();
		WebElement select = wait.until(ExpectedConditions.elementToBeClickable
	    (By.xpath("//div[@class='oxd-select-option']//span[normalize-space()='Software Engineer']")));
		select.click();
		Email.clear();
		Email.sendKeys(email);
		Contact.clear();
		Contact.sendKeys(contNum);
		resumefile.sendKeys("E:\\AJAY ADE\\Fake Resume.docx");
		keyword.sendKeys(kwrd);
		wait.until(ExpectedConditions.elementToBeClickable(date)).click();;
        Notes.sendKeys(notes);
        checkbox.click();
        saveBtn.click();
		
	}

}

