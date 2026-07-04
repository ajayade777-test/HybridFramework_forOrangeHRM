package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPages {
	WebDriver driver;
	WebDriverWait wait;
	// locate all element using find by
	// click on PIM
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pim;
	// click on add btn
	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement addbtn;
	// clicking on first name
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;
	// click on middle name
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement mdlName;
	// click on lastname
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lstName;
	// click on empid
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement empId;
	// click on save button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebtn;

	// click and refresh employee list
	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement employeeRefresh;

	// serach for employee
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement searchEmp;

	// click on search btn
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement searchbtn;

	public PIMPages(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this); // initializing all @Find BY elements

	}

	public void PIM() {
		wait.until(ExpectedConditions.elementToBeClickable(pim)).click();
		// pim.click();
	}

	public void addbttn() {
		wait.until(ExpectedConditions.elementToBeClickable(addbtn)).click();
	}

	public void addDetails(String firstname, String middlename, String lastname, String empid, String searchem) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.clear();
		firstName.sendKeys(firstname);

		wait.until(ExpectedConditions.visibilityOf(mdlName));
		mdlName.clear();
		mdlName.sendKeys(middlename);

		wait.until(ExpectedConditions.visibilityOf(lstName));
		lstName.clear();
		lstName.sendKeys(lastname);

		wait.until(ExpectedConditions.visibilityOf(empId));
		empId.clear();
		empId.sendKeys(empid);

		wait.until(ExpectedConditions.visibilityOf(savebtn));
		savebtn.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(employeeRefresh));
		employeeRefresh.click();
		
		wait.until(ExpectedConditions.visibilityOf(searchEmp));
		searchEmp.sendKeys(searchem);
		searchEmp.click();
		
		wait.until(ExpectedConditions.visibilityOf(searchbtn));
		searchbtn.click();
		
		

	}

}
