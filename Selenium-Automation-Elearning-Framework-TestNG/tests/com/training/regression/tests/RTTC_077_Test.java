package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RTTC_077_DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_077_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_077_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_077_POM rttc077;
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
		rttc077 = new RTTC_077_POM(driver); 
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
	@Test(dataProvider = "excel-inputs", dataProviderClass = RTTC_077_DataProviders.class)
	public void editOrderTest(String username, String password, String orderid,String addprdct, String qty) throws InterruptedException {
		rttc077.sendUserName(username);					//Enter user-name
		rttc077.sendPassword(password);					//Enter password
		rttc077.clickLoginBtn(); 						//Click login button 
		rttc077.selectOrders();							//Select Orders from Sales menu
		rttc077.sendOrderID(orderid);					//Enter Order ID to filter order list
		rttc077.clickFilterBtn();						//Click on filter button
//		screenShot.captureScreenShot("OriginalOrder");	//Capture Screenshot for Original Order
		Thread.sleep(2000);		
		rttc077.clickEditBtn();							//Click on edit button
		Thread.sleep(3000);		
		rttc077.clickConti();							//Click on continue button after verifying customer details
		Thread.sleep(2000);
		rttc077.clickRemoveBtn();						//Remove product from order
		Thread.sleep(1000);
		rttc077.selectProdQty(addprdct,qty);			//Add another product and quantity
		Thread.sleep(2000);
		rttc077.clickAddProdBtn(); 						//Add product
		Thread.sleep(2000);
		rttc077.clickContiCart(); 						//Click on Continue to confirm order
		Thread.sleep(2000);
		rttc077.clickContPayment();						//Click on Continue to confirm shipping address
		Thread.sleep(2000);
		rttc077.clickContShip(); 						//Click on Continue to confirm payment address
		Thread.sleep(2000);
		rttc077.selShipping(); 							//Select Shipping method
		Thread.sleep(3000);
//		rttc077.selPayment(); 							//Select payment method
		rttc077.clickSaveBtn(); 						//Click on save button
		rttc077.verifyMsg(); 							//Verify Success Message
//		screenShot.captureScreenShot("UpdatedOrder");	//Capture Screenshot for Updated Order
	}
}
