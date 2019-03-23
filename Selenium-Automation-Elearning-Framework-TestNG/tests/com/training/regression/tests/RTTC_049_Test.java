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
import com.training.pom.RTTC_049_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_049_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_049_POM rttc049;
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
		rttc049 = new RTTC_049_POM(driver); 
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
	public void addReturnTest() throws InterruptedException {
		
		//Login to the application as a admin
		rttc049.sendUserName("admin");					//Enter user-name
		rttc049.sendPassword("admin@123");				//Enter password
		rttc049.clickLoginBtn(); 						//Click login button 
		
		//Add new return
		rttc049.selectReturns();						//Select Returns from Sales menu
		rttc049.addNew();								//Click on Add New icon
		rttc049.enterOrderId(107);						//Enter Order Id into Order Id field
		rttc049.enterCustName("Mittal", "Patel");		//Enter Customer's first and last name
		rttc049.enterEmailPhone("mittalpatel@gmail.com", "9988776655");		//Enter Email and telephone number into respective fields
		rttc049.enterProductModel("quis venenatis est ultricies et", "SKU-003");//Enter Product and Model into respective fields
		rttc049.clickSaveprodBtn();						//Click on Save button to save return
		rttc049.verifyRtnMsg();							//Verify the success message
		screenShot.captureScreenShot("ReturnSuccess");	//Capture Screenshot for Successful Return Creation
		Thread.sleep(3000);
		
		rttc049.selectReturns();						//Select Returns from Sales menu
		screenShot.captureScreenShot("BeforeDelete");	//Capture Screenshot for Return List before deleting
		rttc049.deleteReturn();							//Select return to be deleted
		rttc049.clickDeleteBtn(); 						//Click on delete button
		rttc049.deleteAlert(); 							//Accept alert to delete return 
		rttc049.verifyRtnMsg();							//Verify the success message
		screenShot.captureScreenShot("AfterDelete");	//Capture Screenshot for Return List after deleting
		
/*		rttc049.sendCustomerName("Mittal Patel");		//Enter Customer name to filter order list
		rttc049.clickFilterBtn();						//Click on filter button
		screenShot.captureScreenShot("OriginalOrder");	//Capture Screenshot for Original Order
		Thread.sleep(2000);		
		
		rttc049.clickEditBtn();							//Click on edit button
		rttc049.editOrder();							//Edit order
		screenShot.captureScreenShot("UpdatedOrder");	//Capture Screenshot for Updated Order
*/
	}
}
