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
import com.training.pom.CreateRetailOrder_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateRetailOrder_Test {
	
//	Logger log = Logger.getLogger(RetailCreateOrderTest.class);
//    PropertyConfigurator.configure("resources//log4j.properties");
    
	
	private WebDriver driver;
	private String baseUrl;
	private CreateRetailOrder_POM createOrder;
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
		createOrder = new CreateRetailOrder_POM(driver); 
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
	public void createOrderTest() throws InterruptedException {
		createOrder.selectLogin();
		createOrder.sendEmail("mittalpatel@gmail.com");
		createOrder.sendPassword("mittal1");
		createOrder.clickLoginBtn(); 
		createOrder.clickHome();
//		createOrder.selectProduct();
		createOrder.selectOption();
		createOrder.placeOrder();
		screenShot.captureScreenShot("New Order");
	}
}
