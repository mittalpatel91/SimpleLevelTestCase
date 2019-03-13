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
import com.training.pom.RTTC_018_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_018_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_018_POM rttc018;
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
		rttc018 = new RTTC_018_POM(driver); 
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
	public void fileterOrdersTest() {
		rttc018.sendUserName("admin");
		rttc018.sendPassword("admin@123");
		rttc018.clickLoginBtn(); 
		rttc018.selectReturns();
		rttc018.sendReturnId("19");
		rttc018.clickFilterBtn();
		screenShot.captureScreenShot("FilterRtnbyID");
		rttc018.selectReturns();
		rttc018.sendCustomerName("Shilpa");
		rttc018.clickFilterBtn();
		screenShot.captureScreenShot("FilterRtnbyName");
	}
}
