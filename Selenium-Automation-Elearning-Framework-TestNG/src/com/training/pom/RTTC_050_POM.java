package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_050_POM {
	private WebDriver driver; 

	public RTTC_050_POM(WebDriver driver) {
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

	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")	//Locate Customer Menu
	private WebElement customerbtn;

	@FindBy(linkText="Customers")					//Locate Customers from Customer Menu
	private WebElement customers;

	public void selectCust() {						//Select Customers from Customer Menu
		this.customerbtn.click();
		this.customers.click();
	}

	@FindBy(id="input-name")						//Locate Customer Name field
	private WebElement custName;

	public void sendCustNm(String custnm) {			//Enter Customer Name to edit
		this.custName.clear();
		this.custName.sendKeys(custnm);
	}
	
	@FindBy(id="button-filter")						//Locate the Filter button
	private WebElement filterbtn;

	public void clickFilterBtn() {					//Click on Filter button
		this.filterbtn.click();
	}
	
	@FindBy(xpath="//td[@class='text-right']//a[@class='btn btn-primary']")
	private WebElement editBtn;						//Locate the edit Button
	
	public void clickEditBtn() {					//Click on edit icon
		this.editBtn.click();
	}
	
	@FindBy(id="input-firstname")					//Locate First Name field
	private WebElement fname;
	
/*	@FindBy(id="input-lastname")					//Locate Last Name field
	private WebElement lname;
*/	
	public void editCustName(String fname) {		//Clear First Name field and enter new data
		this.fname.clear();
		this.fname.sendKeys(fname);
//		this.lname.clear();
//		this.lname.sendKeys(lname);
	}
	
	@FindBy(linkText="Address 1")					//Locate Address1 tab to update address
	private WebElement add1;
	
	public void clickAddress1Tab() {				//Click on Address1 tab
		this.add1.click();
	}
	
	@FindBy(id="input-postcode1")					//Locate post-code field
	private WebElement postcode;
	
	public void editPostcode(int postcode) {		//Clear existing post-code and enter new post-code
		this.postcode.clear();
		this.postcode.sendKeys(""+postcode);
	}
	
	@FindBy(linkText="Reward Points")				//Locate Reward Points Tab
	private WebElement rewptTab;
	
	public void clickRewardPointTab() {				//Click on Reward Points tab
		this.rewptTab.click();
	}
	
	@FindBy(id="input-reward-description")			//Locate description field
	private WebElement description;
	
	@FindBy(id="input-points")						//Locate points fields
	private WebElement points;
	
	@FindBy(xpath="//button[@id='button-reward']")	//Locate Add Reward Points button
	private WebElement addPtBtn;
	
	public void updateRewardPoints(String description, int points) {//Update Reward points
		this.description.clear();
		this.description.sendKeys(description);
		this.points.clear();
		this.points.sendKeys(""+points);
		this.addPtBtn.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate success message upon adding reward points
	private WebElement msg;
	
	public void verifyMsg() {
		assertEquals(this.msg.getText().replace("\n×", ""),"Success: You have modified customers!");
	}
	
	@FindBy(xpath="//button[@type='submit']")		//Locate save Button
	private WebElement saveBtn;
	
	public void clickSaveBtn() {					//Click on Save Button
		this.saveBtn.click();
	}
	
	 //Success: You have modified customers!      
	 
	 @FindBy(xpath="//div[@class='alert alert-success']")
	 private WebElement finalMsg;
	 
	 public void verifyFinalMsg() {
		 assertEquals(this.finalMsg.getText().replace("\n×", ""),"Success: You have modified customers!");
//		 assertEquals(actualMsg.getText(),"Success: You have modified customers!");
	 }
}
