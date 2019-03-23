package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_049_POM {
	private WebDriver driver; 

	public RTTC_049_POM(WebDriver driver) {
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
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")		//Locate the Sales icon
	private WebElement sales;

	@FindBy(linkText="Returns")						//Locate the Returns option from Sales menu
	private WebElement returns;

	public void selectReturns() {
		this.sales.click();
		this.returns.click();
	}

	@FindBy(xpath="//a[@class='btn btn-primary']")	//Locate add new icon
	private WebElement addnew;
	
	public void addNew() {							//Click on add new button to add new category
		this.addnew.click();
	}
	
	@FindBy(id="input-order-id")					//Locate Order Id field.
	private WebElement orderId;
	
	public void enterOrderId(int orderId) {			//Enter Order Id into Order Id field
		this.orderId.clear();
		this.orderId.sendKeys(""+orderId);
	}
	
	@FindBy(id="input-firstname")					//Locate First Name field.
	private WebElement fname;
	
	@FindBy(id="input-lastname")					//Locate Last Name field.
	private WebElement lname;
	
	public void enterCustName(String fname,String lname) {//Enter Customer name into First Name and Last Name field
		this.fname.clear();
		this.fname.sendKeys(fname);
		this.lname.clear();
		this.lname.sendKeys(lname);
	}
	
	@FindBy(id="input-email")					//Locate Email field.
	private WebElement email;
	
	@FindBy(id="input-telephone")				//Locate Telephone Number field.
	private WebElement phone;
	
	public void enterEmailPhone(String email,String phone) {//Enter Email and telephone number into respective fields
		this.email.clear();
		this.email.sendKeys(email);
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	@FindBy(id="input-product")					//Locate Product field.
	private WebElement product;
	
	@FindBy(id="input-model")				//Locate Model field.
	private WebElement model;
	
	public void enterProductModel(String product,String model) {//Enter Product and Model into respective fields
		this.product.clear();
		this.product.sendKeys(product);
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	@FindBy(xpath="//button[@type='submit']")		//Locate Save button to save order
	private WebElement saveBtn;
	
	public void clickSaveprodBtn()  {				//Save the product
		this.saveBtn.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate success message
	private WebElement msg;
	
	public void verifyRtnMsg() {
		assertEquals(this.msg.getText().replace("\n×", ""),"Success: You have modified returns!");
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")	//Locate a return to delete
	private WebElement rtnToDelete;

	public void deleteReturn() {					//Select return to delete
		this.rtnToDelete.click();
	}
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")	//Locate delete button
	private WebElement deletebtn;
	
	public void clickDeleteBtn() {					//Click on delete button
		this.deletebtn.click();
	}
	
	public void deleteAlert() {						//Accept the alert pop-up
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
}
