package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_078_POM {
	private WebDriver driver; 

	public RTTC_078_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")					//Locate the user-name field.
	private WebElement userName;

	public void sendUserName(String userName) {		//Enter the value in user-name field.
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	@FindBy(id="input-password")					//Locate the password field.
	private WebElement password;

	public void sendPassword(String password) {		//Enter the value in password field.
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	@FindBy(tagName="button")						//Locate the login button
	private WebElement loginBtn;

	public void clickLoginBtn() {					//Click the login button
		this.loginBtn.click(); 
	}

	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-catalog']/a[1]")		//Locate the Catalog icon
	private WebElement catalog;

	@FindBy(linkText="Categories")					//Locate the Categories option from Catalog menu
	private WebElement categories;

	public void selectCategories() {				//Select Categories option from Catalog menu
		this.catalog.click();
		this.categories.click();
	}
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")	//Locate add new icon
	private WebElement addnew;
	
	public void addNew() {					//Click on add new button to add new category
		this.addnew.click();
	}
	
	@FindBy(id="input-name1")						//Locate Category name field.
	private WebElement catname;

	public void enterCategoryNm(String catname) {	//Enter category name to add
		this.catname.clear();
		this.catname.sendKeys(catname);
	}
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")//Locate description Text area
	private WebElement catdesc;
	
	public void enterCatDescrp(String catdesc) {		//Enter category description
		this.catdesc.clear();
		this.catdesc.sendKeys(catdesc);
	}
	
	@FindBy(xpath="//input[@id='input-meta-title1']")	//Locate Meta Tag Title Text box
	private WebElement metatagtitle;
	
	public void enterMetaTagTitle(String metatagtitle) {//Enter Meta Tag Title
		this.metatagtitle.clear();
		this.metatagtitle.sendKeys(metatagtitle);
	}
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")//Locate meta tag description text box
	private WebElement metatagdesc;
	
	public void enterMetaTagDesc(String metatagdesc) {	//Enter Meta Tag Description
		this.metatagdesc.clear();
		this.metatagdesc.sendKeys(metatagdesc);
	}
	
	@FindBy(linkText="Data")						//Locate Data tab
	private WebElement datatab;	
	
	public void navigatetoDataTab() {				//Click on Data tab
		this.datatab.click();
	}
	
	@FindBy(linkText="Design")						//Locate Design tab
	private WebElement designtab;
	
	public void navigatetoDesignTab() {				//Click on Design tab
		this.designtab.click();
	}
	
	@FindBy(xpath="//button[@type='submit']")		//Locate save icon
	private WebElement save;
	
	public void clickSaveBtn() {					//Click on Design tab
		this.save.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate success Message
	private WebElement Msg;
	
	public void verifyCatMsg() {					//Verify Success Message for Category
		assertEquals(this.Msg.getText().replace("\n×", ""),"Success: You have modified categories!");
	}
	
	@FindBy(linkText="Products")					//Locate Products option from Catalog menu
	private WebElement products;
	
	public void selectProducts() {					//Select Products option from Catalog menu
		this.catalog.click();
		this.products.click();
	}
	
	@FindBy(xpath="//input[@placeholder='Product Name']")//Locate Product name text box
	private WebElement prodNm;
	
	public void enterProductName(String prodNm) {	//Enter Product name in Product name field
		this.prodNm.clear();
		this.prodNm.sendKeys(prodNm);
	}
	
	@FindBy(xpath="//input[@id='input-meta-title1']")	//Locate Meta Tag Title for product
	private WebElement metaTagtitle;
	
	public void enterProductMetaTagTitle(String metaTagtitle) {	//Enter Meta Tag Title in meta tag title field
		this.metaTagtitle.clear();
		this.metaTagtitle.sendKeys(metaTagtitle);
	}
	
	@FindBy(linkText="Data")						//Locate Data tab
	private WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")		//Locate Model field
	private WebElement model;
	
	@FindBy(linkText="SKU-003")							//Locate Model field option
	private WebElement modelopt;
	
	public void updateDataTab() {					//Fill the required fields in Data tab
		this.dataTab.click();
		this.model.sendKeys("SKU-003");
//		this.modelopt.click();
	}
	
	@FindBy(linkText="Links")
	private WebElement linksTab;					//Locate Links tab
	
	@FindBy(xpath="//input[@id='input-category']")	//Locate Categories field in Links tab
	private WebElement prodCategories;
	
	@FindBy(linkText="Electronic")
	private WebElement catelect;
	
	@FindBy(linkText="TV")
	private WebElement cattv;
	
	@FindBy(linkText="Kitchen")
	private WebElement catkitchen;
	
	@FindBy(linkText="Sports")
	private WebElement catsports;
	
	public void updateLinksTab(String prodcat) {					//Fill the required fields in Links tab
		this.linksTab.click();
		this.prodCategories.click();
		this.prodCategories.sendKeys(prodcat);
		switch(prodcat) {
		case "Electronic":
			this.catelect.click();
			break;
		case "TV":
			this.cattv.click();
			break;
		case "Kitchen":
			this.catkitchen.click();
			break;
		case "Sports":
			this.catsports.click();
			break;
		default:
			System.out.println("Invalid Category");
			break;
		}
	}
	
	@FindBy(linkText="Attribute")
	private WebElement attriTab;					//Locate Attribute tab
	
	public void verifyAttributeTab() {				//Click on Attribute tab and verify values
		this.attriTab.click();
	}
	
	@FindBy(linkText="Option")
	private WebElement optTab;						//Locate Option tab
	
	public void verifyOptionTab() {					//Click on Option tab and verify values
		this.optTab.click();
	}
	
	@FindBy(linkText="Recurring")
	private WebElement recurrTab;					//Locate Recurring tab
	
	public void verifyRecurringTab() {				//Click on Recurring tab and verify values
		this.recurrTab.click();
	}
	
	@FindBy(linkText="Discount")
	private WebElement discountTab;					//Locate Discount tab
	
	public void verifyDiscountTab() {				//Click on Discount tab and verify values
		this.discountTab.click();
	}
	
	@FindBy(linkText="Special")
	private WebElement specialTab;					//Locate Special tab
	
	public void verifySpecialTab() {				//Click on Special tab and verify values
		this.specialTab.click();
	}
	
	@FindBy(linkText="Image")
	private WebElement imageTab;					//Locate Image tab
	
	public void verifyImageTab() {					//Click on Image tab and verify values
		this.imageTab.click();
	}
	
	@FindBy(linkText="Reward Points")
	private WebElement rewardTab;					//Locate Reward Points tab
	
	public void verifyRewardPtTab() {				//Click on Reward Points tab and verify values
		this.rewardTab.click();
	}
	
	@FindBy(linkText="Design")
	private WebElement designTab;					//Locate Design tab
	
	public void verifyDesignTab() {					//Click on Design tab and verify values
		this.rewardTab.click();
	}
	
	@FindBy(xpath="//button[@type='submit']")		//Locate Save button to save order
	private WebElement saveBtn;
	
	public void clickSaveprodBtn()  {				//Save the product
		this.saveBtn.click();
	}
	
	public void verifyProdMsg() {					//Verify Success Message for Product
		assertEquals(this.Msg.getText().replace("\n×", ""),"Success: You have modified products!");
	}
}
