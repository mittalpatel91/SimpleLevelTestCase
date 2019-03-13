package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_019_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_019_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_019_POM rttc019;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc019 = new RTTC_019_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void deleteOrdersTest() {
		rttc019.sendUserName("admin");
		rttc019.sendPassword("admin@123");
		rttc019.clickLoginBtn(); 
		rttc019.selectReturns();
		rttc019.sendCustomerName("Shilpa");		//this 2 steps are extra steps so that returns created by new users will not get deleted...
		rttc019.clickFilterBtn();				//this 2 steps are extra steps so that returns created by new users will not get deleted...
		rttc019.deleteReturn();
		rttc019.clickDeleteBtn();
		screenShot.captureScreenShot("ReturnlistBefore");
		rttc019.deleteAlert();
		screenShot.captureScreenShot("ReturnlistAfter");
	}
}
