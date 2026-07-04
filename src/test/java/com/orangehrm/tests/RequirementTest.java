package com.orangehrm.tests;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RequirementPage;


public class RequirementTest extends BaseTest {
	
	@Test
	public void addCandidates() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login("Admin", "admin123");
		
		
		RequirementPage rqrpg = new RequirementPage(driver);
		rqrpg.clkrqrMenu();
		rqrpg.clkOnadd();
		Reporter.log("Clicked on Requirement Menu", true);
		rqrpg.allDetails("sia", "aj", "ade", "sia1@gmail.com", "7776665554",
				"Immediate Joiner", "Required Experience Candidate Only");
	
		Reporter.log("successfully added candidate in requirement menu" , true);
		
		
	
	}
}
