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
import com.training.pom.RTTC_017_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_017_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_017_POM rttc017;
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
		rttc017 = new RTTC_017_POM(driver); 
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
		rttc017.sendUserName("admin");
		rttc017.sendPassword("admin@123");
		rttc017.clickLoginBtn(); 
		rttc017.selectOrders();
		rttc017.sendCustomerName("Mittal Patel");	//this 2 steps are extra steps so that orders created by other users will not get deleted...
		rttc017.clickFilterBtn();					//this 2 steps are extra steps so that orders created by other users will not get deleted...
		rttc017.deleteOrder();
		rttc017.clickDeleteBtn();
		screenShot.captureScreenShot("OrderlistBefore");
		rttc017.deleteAlert();
		screenShot.captureScreenShot("OrderlistAfter");
	}
}
