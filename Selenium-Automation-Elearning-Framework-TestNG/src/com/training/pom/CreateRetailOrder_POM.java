package com.training.pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRetailOrder_POM {
	private WebDriver driver; 

	public CreateRetailOrder_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement selectlogin;

	public void selectLogin() {
		this.selectlogin.click();
	}

	@FindBy(id="input-email")
	private WebElement email;

	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	@FindBy(id="input-password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	@FindBy(xpath="//i[@class='fa fa-home']")
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


	@FindBy(xpath="//span[contains(text(),'Shop Now')]")
	private WebElement shopnow;

	@FindBy(xpath="//span[contains(text(),'Ethnic')]")
	private WebElement option;

	public void selectOption() {
		this.shopnow.click();
		this.option.click();
	}

//	@FindBy(xpath="//a[contains(text(),'Integer vitae iaculis massa')]")
	@FindBy(xpath="//a[@href='http://retail.upskills.in/ethnic/integer-vitae-iaculis-massa']//span//span//img[contains(@class,'lazyloaded')]")
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
		Thread.sleep(3000);
		this.addtocartbtn.click();
		Thread.sleep(5000);
		this.cart.click();
		this.checkoutbtn.click();
		this.step2Continuebtn.click();
		this.step3Continuebtn.click();
		this.step4Continuebtn.click();
		this.agreeterms.click();
		this.step5Continuebtn.click();
		this.confirmbtn.click();
	}

}