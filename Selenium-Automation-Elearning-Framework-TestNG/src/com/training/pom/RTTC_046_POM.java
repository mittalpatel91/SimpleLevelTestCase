package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_046_POM {
	private WebDriver driver; 

	public RTTC_046_POM(WebDriver driver) {
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

	@FindBy(linkText="Orders")						//Locate the Orders option from Sales menu
	private WebElement orders;

	public void selectOrders() {					//Select Orders option from Sales menu
		this.sales.click();
		this.orders.click();
	}
	
	@FindBy(id="input-customer")					//Locate Customers field to filter the order list
	private WebElement customername;
	
	public void sendCustomerName(String custname) {	//Enter Customer Name to filter in Customer field
		this.customername.clear();
		this.customername.sendKeys(custname);
	}
	
	@FindBy(id="button-filter")						//Locate Filter button.
	private WebElement filterbtn;

	public void clickFilterBtn() {					//Click on filter button
		this.filterbtn.click();
	}
	
	@FindBy(xpath="//tr[1]//td[8]//a[2]")			//Locate edit icon
	private WebElement edit;
	
	public void clickEditBtn() {					//Click on edit order
		this.edit.click();
	}
	
//	@FindBy(id="button-customer")					//Locate Continue button
	@FindBy(xpath="//button[@id='button-customer']")
	private WebElement contBtn;
	
	@FindBy(xpath="//*[@id=\"cart\"]/tr/td[6]/button")//Locate Remove icon
	private WebElement removeBtn;
	
	@FindBy(id="input-product")						//Locate product list-box
	private WebElement addprodct;
	
	@FindBy(linkText="Lorem ipsum dolor sit amet")
	private WebElement selectproduct;
	
	@FindBy(id="input-quantity")					//Locate product list-box
	private WebElement qty;
	
	@FindBy(id="button-product-add")				//Locate Add product button
	private WebElement addProdBtn;
	
	@FindBy(id="button-cart")						//Locate Continue button to add products to cart
	private WebElement contCart;
	
	@FindBy(xpath="//button[@id='button-payment-address']")//Locate Continue button with same shipping address
	private WebElement contShip;
	
	@FindBy(id="button-save")						//Locate Save button to save order
	private WebElement saveBtn;
	
	public void editOrder() throws InterruptedException {	//Edit the order
		Thread.sleep(2000);
		this.contBtn.click();						//click on continue button after verifying customer details.
		Thread.sleep(2000);
		this.removeBtn.click();						//remove product from order
		this.addprodct.sendKeys("Lorem ipsum dolor sit amet");//select other product to edit the order
		this.selectproduct.click();
		this.qty.clear();							//clear the quantity field
		this.qty.sendKeys("1");						//Enter value to quantity field
		Thread.sleep(2000);
		this.addProdBtn.click();					//Click on Add Product 
		Thread.sleep(2000);
		this.contCart.click();						//Click on Continue to confirm order
		Thread.sleep(2000);
		Actions action = new Actions(this.driver);
		action.moveToElement(contShip).build().perform();
		Thread.sleep(2000);
		this.contShip.click();						//Click on Continue to confirm shipping address
		Thread.sleep(2000);
		
		Select shipmethod = new Select(this.driver.findElement(By.id("input-shipping-method")));
		shipmethod.selectByVisibleText("Free Shipping - Rs.0");
		this.saveBtn.click();						//Click on Save to save modified order
		Thread.sleep(2000);
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate Success Message
	private WebElement msg;
	
	public void verifyMsg() {						//Verify Success Message for Product
		assertEquals(this.msg.getText().replace("\n×", ""),"Success: You have modified orders!");
	}
}
