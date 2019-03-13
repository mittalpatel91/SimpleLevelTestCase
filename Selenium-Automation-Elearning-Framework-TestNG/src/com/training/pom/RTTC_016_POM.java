package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_016_POM {
	private WebDriver driver; 

	public RTTC_016_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
	private WebElement userName;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	@FindBy(id="input-password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	@FindBy(tagName="button")
	private WebElement loginBtn;

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")
	private WebElement sales;

	@FindBy(linkText="Orders")
	private WebElement orders;

	public void selectOrders() {
		this.sales.click();
		this.orders.click();
	}

	@FindBy(id="input-order-id")
	private WebElement orderId;

	public void sendOrderId(String order) {
		this.orderId.clear();
		this.orderId.sendKeys(order);
	}
	@FindBy(id="input-customer")
	private WebElement customername;
	
	public void sendCustomerName(String custname) {
		this.customername.clear();
		this.customername.sendKeys(custname);
	}
	
	@FindBy(id="button-filter")
	private WebElement filterbtn;

	public void clickFilterBtn() {
		this.filterbtn.click();
	}


}
