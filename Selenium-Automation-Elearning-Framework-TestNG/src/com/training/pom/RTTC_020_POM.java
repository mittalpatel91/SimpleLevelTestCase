package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_020_POM {
	private WebDriver driver; 

	public RTTC_020_POM(WebDriver driver) {
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

	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement customerbtn;

	@FindBy(linkText="Customers")
	private WebElement customers;

	public void selectCust() {
		this.customerbtn.click();
		this.customers.click();
	}

	@FindBy(id="input-name")
	private WebElement custName;

	public void sendCustNm(String custnm) {
		this.custName.clear();
		this.custName.sendKeys(custnm);
	}
	@FindBy(id="input-email")
	private WebElement email;
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	@FindBy(id="button-filter")
	private WebElement filterbtn;

	public void clickFilterBtn() {
		this.filterbtn.click();
	}


}
