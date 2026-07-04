package com.orangehrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    public static WebDriver driver;

    public void configureReport() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss").format(new Date());
        String reportName = "HybridFrameworkTestReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "testpc");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser", "Edge");
        reports.setSystemInfo("User Name", "Sindhu");

        htmlReporter.config().setDocumentTitle("Extent Listener Report");
        htmlReporter.config().setReportName("Hybrid Framework Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("Extent Listener started, report will be generated...");
        
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
        System.out.println("Extent Listener finished, report flushed to disk.");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.PASS, "Test Passed: " + result.getName());
        attachScreenshot(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        attachScreenshot(result.getName());
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }
    
    // Utility method to capture screenshot in folder
//    public void attachScreenshot(String testName) {
//        if (driver != null) {
//            String screenshotDir = System.getProperty("user.dir") + "/Screenshots";
//            new File(screenshotDir).mkdirs(); // ensure folder exists
//
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
//            String screenshotPath = screenshotDir + "/" + testName + "-" + timestamp + ".png";
//
//            try {
//                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(src, new File(screenshotPath));
//                test.addScreenCaptureFromPath(screenshotPath, "Screenshot for: " + testName);
//                System.out.println("Screenshot saved at: " + screenshotPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Driver is null, screenshot not captured!");
//        }
//    }
    
 // Utility method to capture screenshot in Extent Reports
    public void attachScreenshot(String testName) {
        if (driver != null && test != null) {  // also check test is not null
            String screenshotDir = System.getProperty("user.dir") + "/Screenshots";
            new File(screenshotDir).mkdirs(); // ensure folder exists

            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String screenshotPath = screenshotDir + "/" + testName + "-" + timestamp + ".png";

            try {
                // Capture screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File(screenshotPath);
                FileUtils.copyFile(src, dest);

                // Attach screenshot to Extent report
                test.addScreenCaptureFromPath(dest.getAbsolutePath(), "Screenshot for: " + testName);

                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver or ExtentTest is null, screenshot not captured!");
        }
    }


}
