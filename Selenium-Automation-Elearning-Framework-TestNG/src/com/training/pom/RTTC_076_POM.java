package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_076_POM {
	private WebDriver driver; 

	public RTTC_076_POM(WebDriver driver) {
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
	
	@FindBy(id="input-order-id")					//Locate Order ID field to filter the order list
	private WebElement orderid;
	
	public void sendOrderID(String orderid) {	//Enter Order ID to filter in Customer field
		this.orderid.clear();
		this.orderid.sendKeys(orderid);
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
	
	public void clickConti() {
		this.contBtn.click();						//click on continue button after verifying customer details.
	}
	
	@FindBy(xpath="//*[@id=\"cart\"]/tr/td[6]/button")//Locate Remove icon
	private WebElement removeBtn;
	
	public void clickRemoveBtn() {
		this.removeBtn.click();						//remove product from order
	}
	
	@FindBy(id="input-product")						//Locate product list-box
	private WebElement addprdct;
	
	@FindBy(linkText="Integer vitae iaculis massa")
	private WebElement prod1;
	
	@FindBy(linkText="Nullam sodales in purus vel auctor")
	private WebElement prod2;
	
	@FindBy(linkText="quis venenatis est ultricies et")
	private WebElement prod3;
	
	@FindBy(linkText="Lorem ipsum dolor sit amet")
	private WebElement prod4;
	
	@FindBy(id="input-quantity")					//Locate product list-box
	private WebElement qty;
	
	public void selectProdQty(String addprdct, String qty) {
		this.addprdct.sendKeys(addprdct);			//select other product to edit the order
		
		switch(addprdct) {
		
		case "Integer vitae iaculis massa":
			this.prod1.click();
			break;
		case "Nullam sodales in purus vel auctor":
			this.prod2.click();
			break;
		case "quis venenatis est ultricies et":
			this.prod3.click();
			break;
		case "Lorem ipsum dolor sit amet":
			this.prod4.click();
			break;
		default:
			System.out.println();
		}
		this.qty.clear();							//clear the quantity field
		this.qty.sendKeys(qty);						//Enter value to quantity field
	}
	
	
	@FindBy(id="button-product-add")				//Locate Add product button
	private WebElement addProdBtn;
	
	public void clickAddProdBtn() {
		this.addProdBtn.click();					//Click on Add Product
	}
	
	@FindBy(id="button-cart")						//Locate Continue button to add products to cart
	private WebElement contCart;
	
	public void clickContiCart() {
		this.contCart.click();						//Click on Continue to confirm order
	}
	
	@FindBy(xpath="//button[@id='button-payment-address']")//Locate Continue button with payment address
	private WebElement contpayment;
	
	public void clickContPayment() throws InterruptedException {
		Actions action = new Actions(this.driver);
		action.moveToElement(contpayment).build().perform();
		Thread.sleep(2000);
		this.contpayment.click();						//Click on Continue to confirm shipping address
		System.out.println("Clicked on conntinue button--- payment address");
	}
	
	@FindBy(id="button-shipping-address")//Locate Continue button with same shipping address
	private WebElement contShip;
	
	public void clickContShip() throws InterruptedException {
		Actions action = new Actions(this.driver);
		action.moveToElement(contShip).build().perform();
		Thread.sleep(2000);
		this.contShip.click();						//Click on Continue to confirm shipping address
		System.out.println("Clicked on conntinue button--- shipping address");
	}
	
	@FindBy(id="input-shipping-method")				//Locate shipping Method Drop-down
	private WebElement shipping;
	
	public void selShipping() {
		Select shipmethod = new Select(this.shipping);
		shipmethod.selectByVisibleText("Free Shipping - Rs.0");	//Select Shipping method
	}
	
/*	@FindBy(id="input-payment-method")				//Locate Payment method drop-down
	private WebElement payment;
	
	public void selPayment() {
		Select paymethod = new Select(this.payment);
		paymethod.selectByVisibleText("Cash On Delivery");	//Select Payment method
	}*/
	
	@FindBy(id="button-save")						//Locate Save button to save order
	private WebElement saveBtn;
	
	public void clickSaveBtn() {
		this.saveBtn.click();						//Click on Save to save modified order
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate Success Message
	private WebElement msg;
	
	public void verifyMsg() {						//Verify Success Message for Product
		assertEquals(this.msg.getText().replace("\n×", ""),"Success: You have modified orders!");
	}
	
	@FindBy(xpath="//tr[1]//td[8]//a[1]")
	private WebElement vieworder;					//Locate view order button
	
	public void clickViewOrderBtn() {				//Click on view order button
		this.vieworder.click();
	}
	
	@FindBy(xpath="//table[2]//tbody[1]//tr[1]//td[1]")
	private WebElement orderprod;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/div[2]/table[2]/tbody/tr[1]/td[3]")
	private WebElement orderqty;
	
	public void verifyProdQtyDB(String product,String qty) {
		assertEquals(this.orderprod.getText(),product);
		assertEquals(this.orderqty.getText(),qty);
	}
}
