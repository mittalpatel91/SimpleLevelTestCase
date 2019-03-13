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
import com.training.pom.RTTC_020_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_020_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_020_POM rttc020;
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
		rttc020 = new RTTC_020_POM(driver); 
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
	public void fileterOrdersTest() throws InterruptedException {
		rttc020.sendUserName("admin");
		rttc020.sendPassword("admin@123");
		rttc020.clickLoginBtn(); 
		rttc020.selectCust();
		rttc020.sendCustNm("Mittal Patel");
		rttc020.clickFilterBtn();
		screenShot.captureScreenShot("FilterbyName");
		Thread.sleep(3000);
		rttc020.selectCust();
		rttc020.sendEmail("mittalpatel@gmail.com");
		rttc020.clickFilterBtn();
		screenShot.captureScreenShot("FilterOrderbyName");
	}
}
