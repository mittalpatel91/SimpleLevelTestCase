package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_019_POM {
	private WebDriver driver; 

	public RTTC_019_POM(WebDriver driver) {
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

	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Returns')]")
	private WebElement returns;

	public void selectReturns() {
		this.sales.click();
		this.returns.click();
	}

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	private WebElement rtntoDel;

	public void deleteReturn() {
		this.rtntoDel.click();
	}
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deletebtn;
	
	public void clickDeleteBtn() {
		this.deletebtn.click();
	}
	
	public void deleteAlert() {
		Alert alert = this.driver.switchTo().alert();
		alert.accept();
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
