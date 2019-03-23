package com.training.pom;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_047_POM {

	private WebDriver driver; 

	public RTTC_047_POM(WebDriver driver) {
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
	private WebElement orderId;

	public void sendOrderId(String order) {			//Enter Order ID to filter in Order ID field
		this.orderId.clear();
		this.orderId.sendKeys(order);
	}

//	@FindBy(id="input-order-status")				//Locate Order ID field to filter the order list
//	private WebElement orderSt;

	public void sendOrderStatus(String status) {	//Enter Order Status to filter in Order Status field
		Select orderSt = new Select(this.driver.findElement(By.id("input-order-status")));
		orderSt.selectByVisibleText(status);	//Valid values: Pending, Complete
	}

	@FindBy(id="input-date-added")					//Locate Date Added field to filter the order list
	private WebElement dateAdded;

	/*	@FindBy(xpath="/html/body/div[2]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement monthYear;

	Calendar calendar = new GregorianCalendar();
	int year = calendar.get(Calendar.YEAR);

	//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom pull-right']//span[@class='month'][contains(text(),'Jul')]
	@FindBy(xpath="//span[@class='month'][contains(text(),'Jan')]")
	private WebElement jan;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Feb')]")
	private WebElement feb;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Mar')]")
	private WebElement mar;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Apr')]")
	private WebElement apr;
	@FindBy(xpath="//span[@class='month'][contains(text(),'May')]")
	private WebElement may;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Jun')]")
	private WebElement jun;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Jul')]")
	private WebElement jul;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Aug')]")
	private WebElement aug;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Sep')]")
	private WebElement sep;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Oct')]")
	private WebElement oct;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Nov')]")
	private WebElement nov;
	@FindBy(xpath="//span[@class='month'][contains(text(),'Dec')]")
	private WebElement dec;

	@FindBy(xpath="//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom pull-right']//div[@class='datepicker-months']//th[@class='next'][contains(text(),'›')]")
	private WebElement next;

	@FindBy(xpath="//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom pull-right']//div[@class='datepicker-months']//th[@class='prev'][contains(text(),'‹')]")
	private WebElement prev;

	//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom pull-right']//td[@class='day'][contains(text(),'29')]
	@FindBy(xpath="//td[@class='day'][contains(text(),'29')]")
	private WebElement dt29;
	 */	
	public void enterDateAdded(int date,int month,int year) {		//Enter Customer Name to filter in Customer field
		this.dateAdded.clear();	
		this.dateAdded.sendKeys(year+"-"+month+"-"+date);

		/*		this.monthYear.click();			//Click on current month-year to select month and year.

		//Logic to select year:::
				if(this.year>year)
				{
					System.out.println("User has entered year as "+year);
					int n = this.year-year;
					for(int i=0;i<n;i++) {
						this.prev.click();
					}
				}
				else if (this.year<year)
				{
					System.out.println("User has entered year as "+year);
					int n = year-this.year;
					for(int i=0;i<n;i++) {
						this.next.click();
					}
				}
				else
				{
					System.out.println("User has entered year as "+year);
				}

		//Logic to select month:::

		switch (month)					//Switch case scenario to click on month
		{
			case 1:
				this.jan.click();
				break;
			case 2:
				this.feb.click();
				break;
			case 3:
				this.mar.click();
				break;
			case 4:
				this.apr.click();
				break;
			case 5:
				this.may.click();
				break;
			case 6:
				this.jun.click();
				break;
			case 7:
				this.jul.click();
				break;
			case 8:
				this.aug.click();
				break;
			case 9:
				this.sep.click();
				break;
			case 10:
				this.oct.click();
				break;
			case 11:
				this.nov.click();
				break;
			case 12:
				this.dec.click();
				break;
			default:
				System.out.println("Please enter month between 1 to 12.");
				 break;
		}		*/				
	}
	
	@FindBy(id="input-customer")					//Locate Customers field to filter the order list
	private WebElement customername;

	public void sendCustomerName(String custname) {	//Enter Customer Name to filter in Customer field
		this.customername.clear();
		this.customername.sendKeys(custname);
	}
	
	@FindBy(id="input-total")
	private WebElement total;
	
	public void sendTotalAmt(int amt) {
		this.total.clear();
		this.total.sendKeys(""+amt);
	}
	
	@FindBy(id="input-date-modified")
	private WebElement dtModified;
	
	public void enterDtModified(int date, int month, int year) {
		this.dtModified.clear();
		this.dtModified.sendKeys(year+"-"+month+"-"+date);
	}
	
	@FindBy(id="button-filter")						//Locate Filter button.
	private WebElement filterbtn;

	public void clickFilterBtn() {					//Click on filter button
		this.filterbtn.click();
	}
}
