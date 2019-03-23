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
import com.training.pom.RTTC_050_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_050_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_050_POM rttc050;
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
		rttc050 = new RTTC_050_POM(driver); 
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
	public void updateCustomerTest() throws InterruptedException {
		rttc050.sendUserName("admin");								//Enter user-name
		rttc050.sendPassword("admin@123");							//Enter password
		rttc050.clickLoginBtn(); 									//Enter Login button
		
		rttc050.selectCust();										//Select Customers from Customer Menu
		rttc050.sendCustNm("Patel");								//Enter Customer name to edit
		rttc050.clickFilterBtn();									//Click on Filter button
		rttc050.clickEditBtn(); 									//Click on Edit button
		rttc050.editCustName("Mittal");								//Clear existing first name and enter a new name
//		screenShot.captureScreenShot("CustGeneralTab");				//Capture screenshot of General tab of Customers
		Thread.sleep(2000);
		rttc050.clickAddress1Tab(); 								//Click on Address1 tab
		rttc050.editPostcode(560037);								//Clear existing post-code and enter a new post-code
//		screenShot.captureScreenShot("CustAddress1Tab");			//Capture screenshot of Address1 tab of Customers
		Thread.sleep(2000);
		rttc050.clickRewardPointTab(); 								//Click on Reward Points tab
		rttc050.updateRewardPoints("Review", 0 );					//Update Reward Points for a customer
		rttc050.verifyMsg(); 										//Verify message upon adding reward points
//		screenShot.captureScreenShot("CustRewardPointsTab");		//Capture screenshot of Reward Points tab of Customers
		Thread.sleep(2000);
		rttc050.clickSaveBtn(); 									//Click on Save Button
//		screenShot.captureScreenShot("SuccessMsg");					//Capture screenshot of Success Message for modification of Customer
		Thread.sleep(2000);
		rttc050.verifyFinalMsg();									//Verify final success Message
	}
}
