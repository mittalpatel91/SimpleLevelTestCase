package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RTTC_079_DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_079_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_079_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_079_POM rttc079;
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
		rttc079 = new RTTC_079_POM(driver); 
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
	@Test(dataProvider = "excel-inputs", dataProviderClass = RTTC_079_DataProviders.class)
	public void addCategoryProductTest(String username,String password,String catname,String catdesc,String catmetatitle,String catmetadesc,String prodname,String prodmetatitle,String prodcat) throws InterruptedException {
		rttc079.sendUserName(username);					//Enter user-name
		rttc079.sendPassword(password);					//Enter password
		rttc079.clickLoginBtn(); 						//Click login button 

		rttc079.selectCategories();						//Select Categories from Catalog menu
		rttc079.addNew();								//Click on add new icon to add category

		//Add new Category with required attributes:::
		rttc079.enterCategoryNm(catname);				//Enter Category Name
		rttc079.enterCatDescrp(catdesc);				//Enter Category Description
		rttc079.enterMetaTagTitle(catmetatitle);		//Enter Meta Tag Title
		rttc079.enterMetaTagDesc(catmetadesc);			//Enter Meta Tag Description
//		screenShot.captureScreenShot("NewCategoryGeneral");	//Capture Screenshot of General tab while adding new category
		Thread.sleep(2000);
		rttc079.navigatetoDataTab();					//Click on Data tab
//		screenShot.captureScreenShot("NewCategoryData");//Capture Screenshot of Data tab while adding new category
		Thread.sleep(2000);
		rttc079.navigatetoDesignTab();					//Click on Design tab
//		screenShot.captureScreenShot("NewCategoryDesign");//Capture Screenshot of Design tab while adding new category
		Thread.sleep(2000);
		rttc079.clickSaveBtn();							//Click on Save
		
		if(catname.contentEquals("") || catmetatitle.contentEquals(""))
			rttc079.warnMsg();							//Verify warning message for any error
		else if(catdesc.contentEquals("") || catmetadesc.contentEquals(""))
			rttc079.successCatMsg(); 					//Verify Success Message for adding category
		else
			rttc079.successCatMsg(); 					//Verify Success Message for adding category
//		screenShot.captureScreenShot("SaveCategory");	//Capture Screenshot of saved new category
		Thread.sleep(2000);
		
		//Add new Product with required attributes:::
		rttc079.selectProducts();						//Select Products from Catalog menu
		rttc079.addNew();								//Click on add new icon to add product
		rttc079.enterProductName(prodname);				//Enter product name in product name field
//		screenShot.captureScreenShot("Product_General");//Capture Screenshot for General Tab		
		rttc079.enterProductMetaTagTitle(prodmetatitle);//Enter Product Meta Tag title
		rttc079.updateDataTab();						//Fill the required details in Data tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Data");	//Capture Screenshot for Data Tab		
		rttc079.updateLinksTab(prodcat);				//Fill the required details in Links tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Links");	//Capture Screenshot for Links Tab
		rttc079.verifyAttributeTab();					//Verify the details in Attributes tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Attributes");//Capture Screenshot for Attributes Tab
		rttc079.verifyOptionTab();						//Verify the details in Option tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Option");	//Capture Screenshot for Option Tab
		rttc079.verifyRecurringTab();					//Verify the details in Recurring tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Recurring");//Capture Screenshot for Recurring Tab
		rttc079.verifyDiscountTab();					//Verify the details in Discount tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Discount");//Capture Screenshot for Discount Tab
		rttc079.verifySpecialTab();						//Verify the details in Special tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Special");//Capture Screenshot for Special Tab
		rttc079.verifyImageTab();						//Verify the details in Image tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Image");//Capture Screenshot for Image Tab
		rttc079.verifyRewardPtTab();					//Verify the details in Reward Points tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_RewardPoints");//Capture Screenshot for Reward Points Tab
		rttc079.verifyDesignTab();						//Verify the details in Design tab
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Design");//Capture Screenshot for Design Tab
		rttc079.clickSaveprodBtn();						//Click on Save button to save new product
		
		if(prodname.contentEquals("") || prodmetatitle.contentEquals(""))
			rttc079.warnMsg();							//Verify warning message for any error
		else if(prodcat.contentEquals(""))
			rttc079.successProdMsg(); 					//Verify Success Message for adding product
		else
			rttc079.successProdMsg(); 					//Verify Success Message for adding product
		Thread.sleep(2000);
//		screenShot.captureScreenShot("Product_Add");	//Capture Screenshot for successful product addition
	}
}
