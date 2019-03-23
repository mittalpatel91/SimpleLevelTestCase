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
import com.training.pom.RTTC_046_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_046_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_046_POM rttc046;
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
		rttc046 = new RTTC_046_POM(driver); 
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
	public void editOrderTest() throws InterruptedException {
		rttc046.sendUserName("admin");					//Enter user-name
		rttc046.sendPassword("admin@123");				//Enter password
		rttc046.clickLoginBtn(); 						//Click login button 

		rttc046.selectOrders();							//Select Orders from Sales menu
		rttc046.sendCustomerName("Mittal Patel");		//Enter Customer name to filter order list
		rttc046.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("OriginalOrder");	//Capture Screenshot for Original Order
		Thread.sleep(2000);		
		
		rttc046.clickEditBtn();							//Click on edit button
		rttc046.editOrder();							//Edit order
		rttc046.verifyMsg(); 							//Verify Success Message
		screenShot.captureScreenShot("UpdatedOrder");	//Capture Screenshot for Updated Order
	}
}
