package com.dxc.entities;

import java.sql.Date;

public class Product 
{
	private int pid;
	private String pname;
	private double price;
	private Date dop;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int eid) {
		this.pid = eid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDop() {
		return dop;
	}
	public void setDop(Date dop) {
		this.dop = dop;
	}
	
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", price=" + price + ", dop=" + dop + "]";
	}
}
