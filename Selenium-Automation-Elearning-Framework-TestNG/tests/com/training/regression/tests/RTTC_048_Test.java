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
import com.training.pom.RTTC_048_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_048_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_048_POM rttc048;
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
		rttc048 = new RTTC_048_POM(driver); 
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
	public void addCategoryProductTest() throws InterruptedException {
		rttc048.sendUserName("admin");					//Enter user-name
		rttc048.sendPassword("admin@123");				//Enter password
		rttc048.clickLoginBtn(); 						//Click login button 

		rttc048.selectCategories();						//Select Categories from Catalog menu
		rttc048.addNew();								//Click on add new icon to add category

		//Add new Category with required attributes:::
		rttc048.enterCategoryNm("ORNAMENTS");			//Enter Category Name
		rttc048.enterCatDescrp("ornaments for ladies");	//Enter Category Description
		rttc048.enterMetaTagTitle("ORNAMENTS");			//Enter Meta Tag Title
		rttc048.enterMetaTagDesc("ornaments for ladies");//Enter Meta Tag Description
		screenShot.captureScreenShot("NewCategoryGeneral");	//Capture Screenshot of General tab while adding new category
		Thread.sleep(2000);
		rttc048.navigatetoDataTab();					//Click on Data tab
		screenShot.captureScreenShot("NewCategoryData");//Capture Screenshot of Data tab while adding new category
		Thread.sleep(2000);
		rttc048.navigatetoDesignTab();					//Click on Design tab
		screenShot.captureScreenShot("NewCategoryDesign");//Capture Screenshot of Design tab while adding new category
		Thread.sleep(2000);
		rttc048.clickSaveBtn();							//Click on Save
		rttc048.verifyCatMsg(); 						//Verify Success Message for adding category
		screenShot.captureScreenShot("SaveCategory");	//Capture Screenshot of saved new category
		Thread.sleep(2000);
		
		//Add new Product with required attributes:::
		rttc048.selectProducts();						//Select Products from Catalog menu
		rttc048.addNew();								//Click on add new icon to add product
		rttc048.enterProductName("Finger Ring");		//Enter product name in product name field
		screenShot.captureScreenShot("Product_General");//Capture Screenshot for General Tab		
		rttc048.enterProductMetaTagTitle("Finger Ring for ladies");	//Enter Product Meta Tag title
		rttc048.updateDataTab();						//Fill the required details in Data tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Data");//Capture Screenshot for Data Tab		
		rttc048.updateLinksTab();						//Fill the required details in Links tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Links");//Capture Screenshot for Links Tab
		rttc048.verifyAttributeTab();					//Verify the details in Attributes tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Attributes");//Capture Screenshot for Attributes Tab
		rttc048.verifyOptionTab();						//Verify the details in Option tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Option");//Capture Screenshot for Option Tab
		rttc048.verifyRecurringTab();					//Verify the details in Recurring tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Recurring");//Capture Screenshot for Recurring Tab
		rttc048.verifyDiscountTab();					//Verify the details in Discount tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Discount");//Capture Screenshot for Discount Tab
		rttc048.verifySpecialTab();						//Verify the details in Special tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Special");//Capture Screenshot for Special Tab
		rttc048.verifyImageTab();						//Verify the details in Image tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Image");//Capture Screenshot for Image Tab
		rttc048.verifyRewardPtTab();					//Verify the details in Reward Points tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_RewardPoints");//Capture Screenshot for Reward Points Tab
		rttc048.verifyDesignTab();						//Verify the details in Design tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Design");//Capture Screenshot for Design Tab
		rttc048.clickSaveprodBtn();						//Click on Save button to save new product
		rttc048.verifyProdMsg(); 						//Verify Success Message for adding product
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Add");	//Capture Screenshot for successful product addition
	}
}
