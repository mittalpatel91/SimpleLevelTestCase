package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RTTC_078_DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_078_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_078_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_078_POM rttc078;
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
		rttc078 = new RTTC_078_POM(driver); 
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
	@Test(dataProvider = "excel-inputs", dataProviderClass = RTTC_078_DataProviders.class)
	public void addCategoryProductTest(String username,String password,String catname,String catdesc,String catmetatitle,String catmetadesc,String prodname,String prodmetatitle,String prodcat) throws InterruptedException {
		rttc078.sendUserName(username);					//Enter user-name
		rttc078.sendPassword(password);					//Enter password
		rttc078.clickLoginBtn(); 						//Click login button 

		rttc078.selectCategories();						//Select Categories from Catalog menu
		rttc078.addNew();								//Click on add new icon to add category

		//Add new Category with required attributes:::
		rttc078.enterCategoryNm(catname);				//Enter Category Name
		rttc078.enterCatDescrp(catdesc);				//Enter Category Description
		rttc078.enterMetaTagTitle(catmetatitle);		//Enter Meta Tag Title
		rttc078.enterMetaTagDesc(catmetadesc);			//Enter Meta Tag Description
		screenShot.captureScreenShot("NewCategoryGeneral");	//Capture Screenshot of General tab while adding new category
		Thread.sleep(2000);
		rttc078.navigatetoDataTab();					//Click on Data tab
		screenShot.captureScreenShot("NewCategoryData");//Capture Screenshot of Data tab while adding new category
		Thread.sleep(2000);
		rttc078.navigatetoDesignTab();					//Click on Design tab
		screenShot.captureScreenShot("NewCategoryDesign");//Capture Screenshot of Design tab while adding new category
		Thread.sleep(2000);
		rttc078.clickSaveBtn();							//Click on Save
		rttc078.verifyCatMsg(); 						//Verify Success Message for adding category
		screenShot.captureScreenShot("SaveCategory");	//Capture Screenshot of saved new category
		Thread.sleep(2000);
		
		//Add new Product with required attributes:::
		rttc078.selectProducts();						//Select Products from Catalog menu
		rttc078.addNew();								//Click on add new icon to add product
		rttc078.enterProductName(prodname);				//Enter product name in product name field
		screenShot.captureScreenShot("Product_General");//Capture Screenshot for General Tab		
		rttc078.enterProductMetaTagTitle(prodmetatitle);//Enter Product Meta Tag title
		rttc078.updateDataTab();						//Fill the required details in Data tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Data");	//Capture Screenshot for Data Tab		
		rttc078.updateLinksTab(prodcat);				//Fill the required details in Links tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Links");	//Capture Screenshot for Links Tab
		rttc078.verifyAttributeTab();					//Verify the details in Attributes tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Attributes");//Capture Screenshot for Attributes Tab
		rttc078.verifyOptionTab();						//Verify the details in Option tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Option");	//Capture Screenshot for Option Tab
		rttc078.verifyRecurringTab();					//Verify the details in Recurring tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Recurring");//Capture Screenshot for Recurring Tab
		rttc078.verifyDiscountTab();					//Verify the details in Discount tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Discount");//Capture Screenshot for Discount Tab
		rttc078.verifySpecialTab();						//Verify the details in Special tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Special");//Capture Screenshot for Special Tab
		rttc078.verifyImageTab();						//Verify the details in Image tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Image");//Capture Screenshot for Image Tab
		rttc078.verifyRewardPtTab();					//Verify the details in Reward Points tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_RewardPoints");//Capture Screenshot for Reward Points Tab
		rttc078.verifyDesignTab();						//Verify the details in Design tab
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Design");//Capture Screenshot for Design Tab
		rttc078.clickSaveprodBtn();						//Click on Save button to save new product
		rttc078.verifyProdMsg(); 						//Verify Success Message for adding product
		Thread.sleep(2000);
		screenShot.captureScreenShot("Product_Add");	//Capture Screenshot for successful product addition
	}
}
