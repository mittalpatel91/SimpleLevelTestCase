package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_080_POM {
	private WebDriver driver; 

	public RTTC_080_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement selectlogin;

	@FindBy(linkText="LOGIN / REGISTER")
	private WebElement loginReg;
	public void selectLogin() {
		Actions act = new Actions(this.driver);
		act.moveToElement(this.selectlogin).build().perform();
		this.loginReg.click();
	}

	@FindBy(id="input-email")
	private WebElement email;

	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	@FindBy(id="input-password")
	private WebElement userpassword;

	public void sendUserPassword(String password) {
		this.userpassword.clear(); 
		this.userpassword.sendKeys(password); 
	}

	@FindBy(xpath="//input[@value='Login']")
	private WebElement userloginBtn;

	public void clickUserLoginBtn() {
		this.userloginBtn.click(); 
	}

	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement home;

	public void clickHome() {
		this.home.click();
	}

	@FindBy(xpath="//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[13]/div/div/div[2]/div[1]/div[1]/a/span/span/img")
	private WebElement product2buy;
	

	public void selectProduct() {
		Actions action = new Actions(driver);
		action.moveToElement(this.product2buy).perform();
		this.product2buy.click();
	}


	@FindBy(xpath="//span[contains(text(),'Shop')]")
	private WebElement shopnow;

	@FindBy(xpath="//span[contains(text(),'Earrings')]")
	private WebElement option;

	public void selectOption() {
		this.shopnow.click();
		this.option.click();
	}

//	@FindBy(xpath="//a[contains(text(),'Integer vitae iaculis massa')]")
	@FindBy(xpath="//a[contains(text(),'quis venenatis est ultricies et')]")
	private WebElement product;
		
	@FindBy(id="button-cart")
	private WebElement addtocartbtn;

	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/h3/a")
	private WebElement cart;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement checkoutbtn;

	@FindBy(xpath="//input[@id='button-payment-address']")
	private WebElement step2Continuebtn;

	@FindBy(xpath="//input[@id='button-shipping-address']")
	private WebElement step3Continuebtn;

	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement step4Continuebtn;

	@FindBy(xpath="//input[@value='1']")
	private WebElement agreeterms;

	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement step5Continuebtn;

	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement confirmbtn;
	
	public void placeOrder() throws InterruptedException {
		String currentHandle = driver.getWindowHandle();
		this.product.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator(); 
		while(iterator.hasNext())
		{
		    String handle = iterator.next();
		    if(!handle.equals(currentHandle))
		    {
		    driver.switchTo().window(handle);
		    }
		}          	
		Thread.sleep(5000);
		this.addtocartbtn.click();
		Thread.sleep(250);
		this.addtocartbtn.click();
		Thread.sleep(8000);
		this.cart.click();
		this.checkoutbtn.click();
		this.step2Continuebtn.click();
		this.step3Continuebtn.click();
		this.step4Continuebtn.click();
		this.agreeterms.click();
		this.step5Continuebtn.click();
		this.confirmbtn.click();
	}
	
	public void goToAdmin() {
		this.driver.navigate().to("http://retail.upskills.in/admin");
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
	
	@FindBy(id="input-customer")					//Locate customer name
	private WebElement customername;
	
	public void sendCustomerName(String custname) {	//Enter customer name to filter orders
		this.customername.clear();
		this.customername.sendKeys(custname);
	}
	
	@FindBy(id="button-filter")						//Locate Filter button.
	private WebElement filterbtn;

	public void clickFilterBtn() {					//Click on filter button
		this.filterbtn.click();
	}
	
	@FindBy(xpath="//tr[1]//td[8]//a[1]")
	private WebElement vieworder;					//Locate view order button
	
	public void clickViewOrderBtn() {				//Click on view order button
		this.vieworder.click();
	}
	
	@FindBy(xpath="//select[@id='input-order-status']")	//Locate order status list box
	private WebElement orderStatus;
	
	public void selOrderStatus() {
		Select orderstatuslist = new Select(this.orderStatus);
		orderstatuslist.selectByVisibleText("Complete");
	}
	
	@FindBy(xpath="//button[@id='button-history']")	//Locate Add history button
	private WebElement addhistory;
	
	public void clickAddHistoryBtn() {				//Click on add history button.
		this.addhistory.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")//Locate Success Message
	private WebElement msg;
	
	public void verifyMsg() {						//Verify Success Message for Product
		assertEquals(this.msg.getText().replace("\n×", ""),"Success: You have modified orders!");
	}
	
	public void goToCutomerLogin() {
		this.driver.navigate().to("http://retail.upskills.in/");
	}
	
	@FindBy(linkText="MY ORDERS")
	private WebElement myorders;
	
	public void clickMyorder() {
		Actions act = new Actions(this.driver);
		act.moveToElement(this.selectlogin).build().perform();
		this.myorders.click();
	}
	
	@FindBy(xpath="//tr[1]//td[7]//a[1]")
	private WebElement orderhistory;
	
	public void clickViewOrderHistory() {
		this.orderhistory.click();
	}
}