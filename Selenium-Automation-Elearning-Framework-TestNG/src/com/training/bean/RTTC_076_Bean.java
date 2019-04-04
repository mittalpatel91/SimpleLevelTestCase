package com.training.bean;

public class RTTC_076_Bean {
	private String userName;
	private String password;
	private String orderid;
	private String product;
	private String qty;

	public RTTC_076_Bean() {
	}

	public RTTC_076_Bean(String userName, String password,String orderid, String product, String qty) {
		super();
		this.userName = userName;
		this.password = password;
		this.orderid=orderid;
		this.product=product;
		this.qty=qty;
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

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

}
