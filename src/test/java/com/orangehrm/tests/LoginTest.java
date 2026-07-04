package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPages;
import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.ExcelUtils;

public class LoginTest extends BaseTest {

	// using hard coding passing data
//	@Test
//	public void verifyLogin() {
//
//		LoginPage login = new LoginPage(driver);
//		login.enterUsername("Admin");
//		login.enterPassword("admin123");
//		login.clickLogin();
//
//		DashboardPage dashboard = new DashboardPage(driver);
//		Assert.assertTrue(dashboard.isDashboardDisplayed(), " Login Failed!");
//		Reporter.log("Login Successful:", true);
//
//	}
//}

	// using confid.properties file data
//	@Test
//	public void verifyLogin() {
//	    String username = ConfigReader.getProperty("username"); // e.g. Admin
//	    String password = ConfigReader.getProperty("password"); // e.g. admin123
//
//	    LoginPage login = new LoginPage(driver);
//	    login.login(username, password);
//
//	    DashboardPage dashboard = new DashboardPage(driver);
//	    Assert.assertTrue(dashboard.isDashboardDisplayed(), "Login Failed!");
//	    Reporter.log("Login Successful:", true);
//	}
//}

	// using excel files data
	@Test
	public void verifyLoginWithExcelData() throws Exception {
		// Load Excel file
		ExcelUtils.setExcelFile("src/test/resources/Book1.xlsx", "Login");

		// Read first row
		String username = ExcelUtils.getCellData(0, 0);
		String password = ExcelUtils.getCellData(0, 1);

		// Perform login
		LoginPage login = new LoginPage(driver);
		login.login(username, password);

		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.isDashboardDisplayed(), "Login Failed!");
		Reporter.log("Login Successful:", true);

	}

	@Test(dependsOnMethods = "verifyLoginWithExcelData")
	public void PIM() throws InterruptedException {
		PIMPages pm = new PIMPages(driver);
		pm.PIM();
		Reporter.log("Clicked on PIM", true);
		pm.addbttn();
		pm.addDetails("sindhu", "ajay", "ade", "1212", "sindhu ajay ade");
		System.out.println("user created Successfully");
		

	}
}
