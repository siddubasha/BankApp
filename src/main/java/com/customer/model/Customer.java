package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
     private String name;
	@Column
     private String password;
	@Column
     private long adhaarNo; 
	@Column
     private long mobileNo; 
	@Column
     private String mailId;
	@Column
     private String address;
	@Column
     private long money;
	
	
	public Customer() {
		super();
	}
	public Customer(String name, String password, long adhaarNo, long mobileNo, String mailId, String address,
			long money) {
		super();
		this.name = name;
		this.password = password;
		this.adhaarNo = adhaarNo;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.address = address;
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAccountNo() {
		return id;
	}
	public void setAccountNo(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(long adhaarNo) {
		this.adhaarNo = adhaarNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", adhaarNo=" + adhaarNo + ", mobileNo=" + mobileNo
				+ ", mailId=" + mailId + ", address=" + address + ", money=" + money + "]";
	} 
     
     
}
