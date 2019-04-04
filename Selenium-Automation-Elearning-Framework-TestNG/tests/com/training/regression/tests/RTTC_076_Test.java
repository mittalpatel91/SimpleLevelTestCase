package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RTTC_076_DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_076_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_076_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_076_POM rttc076;
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
		rttc076 = new RTTC_076_POM(driver); 
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
	@Test(dataProvider = "db-inputs", dataProviderClass = RTTC_076_DataProviders.class)
	public void editOrderTest(String username, String password, String orderid,String product, String qty ) throws InterruptedException {
		rttc076.sendUserName(username);					//Enter user-name
		rttc076.sendPassword(password);					//Enter password
		rttc076.clickLoginBtn(); 						//Click login button 
		rttc076.selectOrders();							//Select Orders from Sales menu
		rttc076.sendOrderID(orderid);					//Enter Order ID to filter order list
		rttc076.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("OriginalOrder");	//Capture Screenshot for Original Order
		Thread.sleep(2000);		
		rttc076.clickEditBtn();							//Click on edit button
		Thread.sleep(3000);		
		rttc076.clickConti();							//Click on continue button after verifying customer details
		Thread.sleep(2000);
		rttc076.clickRemoveBtn();						//Remove product from order
		Thread.sleep(1000);
		rttc076.selectProdQty(product,qty);				//Add another product and quantity
		Thread.sleep(2000);	
		rttc076.clickAddProdBtn(); 						//Add product
		Thread.sleep(2000);
		rttc076.clickContiCart(); 						//Click on Continue to confirm order
		Thread.sleep(2000);
		rttc076.clickContPayment();						//Click on Continue to confirm shipping address
		Thread.sleep(2000);
		rttc076.clickContShip(); 						//Click on Continue to confirm payment address
		Thread.sleep(2000);
		rttc076.selShipping(); 							//Select Shipping method
		Thread.sleep(3000);
//		rttc076.selPayment(); 							//Select payment method
		rttc076.clickSaveBtn(); 						//Click on save button
		rttc076.verifyMsg(); 							//Verify Success Message
		screenShot.captureScreenShot("UpdatedOrder");	//Capture Screenshot for Updated Order
		rttc076.selectOrders();							//Select Orders from Sales menu
		rttc076.sendOrderID(orderid);					//Enter Order ID to filter order list
		rttc076.clickFilterBtn();						//Click on filter button
		rttc076.clickViewOrderBtn();
		rttc076.verifyProdQtyDB(product, qty);
	}
}
