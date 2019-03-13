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
import com.training.pom.RTTC_016_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_016_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_016_POM rttc016;
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
		rttc016 = new RTTC_016_POM(driver); 
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
		rttc016.sendUserName("admin");
		rttc016.sendPassword("admin@123");
		rttc016.clickLoginBtn(); 
		rttc016.selectOrders();
		rttc016.sendOrderId("192");
		rttc016.clickFilterBtn();
		screenShot.captureScreenShot("FilterOrderbyID");
		rttc016.selectOrders();
		rttc016.sendCustomerName("Mittal Patel");
		System.out.println("Searching with customer name Mittal..");
		rttc016.clickFilterBtn();
		screenShot.captureScreenShot("FilterOrderbyName");
	}
}
