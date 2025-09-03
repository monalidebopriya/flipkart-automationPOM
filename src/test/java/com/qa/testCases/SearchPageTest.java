
	package com.qa.testCases;

	import com.qa.pages.FlipkartHomePage;
	import com.qa.testData.TestData;
	import com.qa.utils.DriverFactory;
	import com.qa.utils.ExtentManager;
	import com.qa.utils.ScreenshotUtils;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.*;

	public class SearchPageTest {

	    WebDriver driver;
	    FlipkartHomePage homePage;
	    ExtentReports extent;
	    ExtentTest test;

	    @BeforeClass
	    public void setUp() {
	        driver = DriverFactory.initDriver();
	        homePage = new FlipkartHomePage();

	        extent = ExtentManager.getInstance();
	    }

	    @Test
	    public void searchForProduct() {
	        test = extent.createTest("Flipkart Search Test");
	        homePage.open();
	        test.log(Status.INFO, "Opened Flipkart website");

	        homePage.closeLoginPopup();
	        test.log(Status.INFO, "Closed login popup");

	        homePage.searchProduct(TestData.SEARCH_ITEM);
	        test.log(Status.INFO, "Searched for: " + TestData.SEARCH_ITEM);

	        boolean result = homePage.verifyResults(TestData.SEARCH_ITEM);
	        Assert.assertTrue(result, "Search results should contain " + TestData.SEARCH_ITEM);
	        test.log(Status.PASS, "Search results displayed successfully");
	    }

	    @AfterMethod
	    public void captureFailure(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
	            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
	            try {
	                test.addScreenCaptureFromPath(screenshotPath);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        DriverFactory.quitDriver();
	        extent.flush(); // generates FlipkartReport.html
	    }
	}

