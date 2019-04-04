package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */
public class DBBean_Proj {
	private String url; 
	private String driver; 
	private String userName; 
	private String password;
	private String orderid;
	private String product;
	private String qty;
	
	public DBBean_Proj(){}
	
	public DBBean_Proj(String url, String driver, String userName, String password,String orderid, String product, String qty) {
		super();
		this.url = url;
		this.driver = driver;
		this.userName = userName;
		this.password = password;
		this.orderid=orderid;
		this.product=product;
		this.qty=qty;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getQuantity() {
		return qty;
	}

	public void setQuantity(String qty) {
		this.qty = qty;
	}
	
}
