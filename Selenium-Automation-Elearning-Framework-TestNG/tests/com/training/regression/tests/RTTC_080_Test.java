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
import com.training.pom.RTTC_080_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_080_Test {
	
//	Logger log = Logger.getLogger(RetailCreateOrderTest.class);
//    PropertyConfigurator.configure("resources//log4j.properties");
    
	
	private WebDriver driver;
	private String baseUrl;
	private RTTC_080_POM rttc080;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/orders.properties");
		properties.load(inStream);
//		log.info("");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc080 = new RTTC_080_POM(driver); 
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
	@Test(priority=1)
	public void rttc080Test() throws InterruptedException {
		rttc080.selectLogin();							//Select login to login to the application
		rttc080.sendEmail("mittalpatel@gmail.com");		//Enter email id
		rttc080.sendUserPassword("mittal1");			//Enter password
		rttc080.clickUserLoginBtn(); 					//Click on login button
		rttc080.clickHome();							//Click on home page
		rttc080.selectOption();							//Select category
		rttc080.placeOrder();							//Place the order
//		screenShot.captureScreenShot("New Order");
		rttc080.goToAdmin();							//Navigate to admin page
		rttc080.sendUserName("admin");					//Enter user-name
		rttc080.sendPassword("admin@123");				//Enter password
		rttc080.clickLoginBtn(); 						//Click login button 
		rttc080.selectOrders();							//Select Orders from Sales menu
		rttc080.sendCustomerName("Mittal Patel");;		//Enter Customer name to filter order list
		rttc080.clickFilterBtn();						//Click on filter button
		rttc080.clickViewOrderBtn();					//Click on view order link
		rttc080.selOrderStatus();				//Select status
		rttc080.clickAddHistoryBtn();					//Click on add history button
		rttc080.verifyMsg(); 							//Verify Success Message
		rttc080.goToCutomerLogin(); 					//Navigate to customer page
		rttc080.selectLogin();							//Select login to login to the application
		rttc080.sendEmail("mittalpatel@gmail.com");		//Enter email id
		rttc080.sendUserPassword("mittal1");			//Enter password
		rttc080.clickUserLoginBtn(); 					//Click on login button
		rttc080.clickMyorder();							//Go to my orders
		rttc080.clickViewOrderHistory();				//View order history
//		screenShot.captureScreenShot("Updated Order");	//Updated order screenshot
	}
}
