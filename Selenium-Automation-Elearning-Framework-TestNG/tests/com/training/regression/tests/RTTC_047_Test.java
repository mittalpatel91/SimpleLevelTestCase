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
import com.training.pom.RTTC_047_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_047_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_047_POM rttc047;
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
		rttc047 = new RTTC_047_POM(driver); 
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
	public void filterOrdersTest() throws InterruptedException {
		rttc047.sendUserName("admin");					//Enter user-name
		rttc047.sendPassword("admin@123");				//Enter password
		rttc047.clickLoginBtn(); 						//Click login button 
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.sendOrderId("192");						//Enter Order Id to filter order list
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyID");//Capture Screenshot for filter by Order Id
		Thread.sleep(2000);
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.sendOrderStatus("Processed");			//Enter Order Id to filter order list
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyStatus");//Capture Screenshot for filter by Order Status 
		Thread.sleep(2000);
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.enterDateAdded(14, 3, 2019);			//Input date in format: DD,MM,YYYY
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyDateAdded");//Capture Screenshot for filter by Date Added 
		Thread.sleep(2000);
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.sendCustomerName("Mittal Patel");		//Enter Customer name to filter order list
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyName");//Capture Screenshot for filter by Customer Name
		Thread.sleep(2000);
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.sendTotalAmt(15000);					//Enter total amount of order
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyAmount");//Capture Screenshot for filter by Total Amount
		Thread.sleep(2000);
		
		rttc047.selectOrders();							//Select Orders from Sales menu
		rttc047.enterDtModified(15, 3, 2019);			//Input date in format: DD,MM,YYYY
		rttc047.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("FilterOrderbyDateModified");//Capture Screenshot for filter by Date Modified
		Thread.sleep(2000);
		
	}
}
